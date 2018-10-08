package com.gympass.app.api.services;

import com.gympass.app.api.core.service.ILapRecordService;
import com.gympass.app.api.models.LapRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
@Slf4j
@Service
public class LapRecordServiceProvider implements ILapRecordService {

    // Obter voltas do motorista
    public List<LapRecord> getLapsFromDriver(List<LapRecord> lapRecords, String driverId) {
        log.info("Method getLapsFromDriver invoked");
        return lapRecords.stream().filter(lap -> lap.getDriver().getId().equals(driverId)).collect(Collectors.toList());
    }

    // Obter os IDs dos motoristas
    public Set<String> getDriversIds(List<LapRecord> lapRecords) {
        log.info("Method getDriversIds invoked");
        return lapRecords.stream().map(lapRecord -> lapRecord.getDriver().getId()).collect(Collectors.toSet());
    }

    // Obter a última volta do motorista
    public LapRecord getLastLapFromDriver(List<LapRecord> lapRecords, String driverId) {
        log.info("Method getLastLapFromDriver invoked");
        Comparator<LapRecord> lapNumberComparator = Comparator.comparing(LapRecord::getLapNumber);
        List<LapRecord> lapsFromDriver = getLapsFromDriver(lapRecords, driverId);

        return lapsFromDriver.stream().max(lapNumberComparator).get();
    }

    // Obter velocidade média total das voltas
    public BigDecimal getTotalAverageSpeedFrom(List<LapRecord> lapRecordsFromDriver) {
        log.info("Method getTotalAverageSpeedFrom invoked");
        BigDecimal sum = lapRecordsFromDriver
                .stream()
                .map(lapRecord -> lapRecord.getAverageLapSpeed())
                .reduce((firstValue, secondValue) -> firstValue.add(secondValue))
                .get();

        return sum.divide(new BigDecimal(lapRecordsFromDriver.size()), RoundingMode.UP);
    }

    // Obter melhor volta do motorista
    public LapRecord getBestLapFrom(List<LapRecord> lapRecordsFromDriver) {
        log.info("Method getBestLapFrom invoked");
        Comparator<LapRecord> durationComparator = Comparator.comparing(LapRecord::getLapDuration);
        return lapRecordsFromDriver.stream().min(durationComparator).get();
    }
}
