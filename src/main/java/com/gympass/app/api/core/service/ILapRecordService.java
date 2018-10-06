package com.gympass.app.api.core.service;

import com.gympass.app.api.models.LapRecord;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
public interface ILapRecordService {

    List<LapRecord> getLapsFromDriver(List<LapRecord> lapRecords, String driverId);

    Set<String> getDriversIds(List<LapRecord> lapRecords);

    LapRecord getLastLapFromDriver(List<LapRecord> lapRecords, String driverId);

    BigDecimal getTotalAverageSpeedFrom(List<LapRecord> lapRecordsFromDriver);

    LapRecord getBestLapFrom(List<LapRecord> lapRecordsFromDriver);
}
