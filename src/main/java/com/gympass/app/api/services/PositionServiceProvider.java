package com.gympass.app.api.services;

import com.gympass.app.api.core.service.ILapRecordDTOConverter;
import com.gympass.app.api.core.service.ILapRecordService;
import com.gympass.app.api.core.service.IPositionDTOConverter;
import com.gympass.app.api.core.service.IPositionService;
import com.gympass.app.api.models.LapRecord;
import com.gympass.app.api.models.dtos.LapRecordDTO;
import com.gympass.app.api.models.dtos.PositionDTO;
import com.gympass.app.api.models.dtos.RaceDTO;
import com.gympass.app.api.utils.DurationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
@Service
public class PositionServiceProvider implements IPositionService {

    private static final int FIRST_PLACE = 0;

    @Autowired
    private IPositionDTOConverter raceDTOToPositionDTOConverter;

    @Autowired
    private ILapRecordDTOConverter lapRecordToLapRecordDTOConverter;

    @Autowired
    private ILapRecordService lapRecordService;

    public List<PositionDTO> getPositions(List<LapRecord> lapRecords){

        Set<String> driversIds = lapRecordService.getDriversIds(lapRecords);
        List<RaceDTO> raceDTOFromEachDriver = new ArrayList<>();
        List<PositionDTO> result = new ArrayList<>();
        int position = 1;

        for (String driverId : driversIds) {
            List<LapRecord> lapsFromDriver = lapRecordService.getLapsFromDriver(lapRecords, driverId);
            LapRecord lastLapFromDriver = lapRecordService.getLastLapFromDriver(lapRecords, driverId);

            Duration totalDuration = DurationUtils.getTotalDurationFrom(lapsFromDriver);
            LapRecord bestLapFromDriver = lapRecordService.getBestLapFrom(lapsFromDriver);
            LapRecordDTO bestLapFromDriverDTO = lapRecordToLapRecordDTOConverter.convert(bestLapFromDriver);
            BigDecimal averageSpeedFromDriver = lapRecordService.getTotalAverageSpeedFrom(lapsFromDriver);

            RaceDTO raceDTO = new RaceDTO.Builder()
                                                .withLapRecord(lastLapFromDriver)
                                                .withTotalDuration(totalDuration)
                                                .withBestLap(bestLapFromDriverDTO)
                                                .withTotalAverageSpeed(averageSpeedFromDriver)
                                                .build();

            raceDTOFromEachDriver.add(raceDTO);
        }

        Comparator<RaceDTO> totalDurationComparator = Comparator.comparing(RaceDTO::getTotalDuration);
        List<RaceDTO> sortedRaceDTO = raceDTOFromEachDriver.stream().sorted(totalDurationComparator).collect(Collectors.toList());

        for(RaceDTO raceDTO : sortedRaceDTO) {
            Duration delayBetweenDrivers = DurationUtils.getDelayBetween(sortedRaceDTO.get(FIRST_PLACE).getLapRecord(), raceDTO.getLapRecord());
            raceDTO.setDelayAfterWinner(delayBetweenDrivers);
            result.add(raceDTOToPositionDTOConverter.convert(position, raceDTO));
            position += 1;
        }

        return result;
    }
}