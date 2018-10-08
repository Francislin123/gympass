package com.gympass.app.api.converters;

import com.gympass.app.api.core.service.ILapRecordDTOConverter;
import com.gympass.app.api.models.LapRecord;
import com.gympass.app.api.models.dtos.LapRecordDTO;
import com.gympass.app.api.utils.DurationUtils;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
public class LapRecordToLapRecordDTOConverter implements ILapRecordDTOConverter {

    public LapRecordDTO convert(LapRecord lapRecord) {

        String hour = String.valueOf(lapRecord.getHour());
        String driverId = lapRecord.getDriver().getId();
        String driverName = lapRecord.getDriver().getName();
        String lapNumber = String.valueOf(lapRecord.getLapNumber());
        String lapDuration = DurationUtils.getFormattedStringFrom(lapRecord.getLapDuration());
        String averageLapSpeed = String.valueOf(lapRecord.getAverageLapSpeed());

        return new LapRecordDTO.Builder()
                .withHour(hour)
                .withDriverId(driverId)
                .withDriverName(driverName)
                .withLapNumber(lapNumber)
                .withlapDuration(lapDuration)
                .withAverageLapSpeed(averageLapSpeed)
                .build();

    }
}
