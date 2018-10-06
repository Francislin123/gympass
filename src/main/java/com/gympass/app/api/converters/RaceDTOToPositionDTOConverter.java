package com.gympass.app.api.converters;

import com.gympass.app.api.core.service.IPositionDTOConverter;
import com.gympass.app.api.models.dtos.LapRecordDTO;
import com.gympass.app.api.models.dtos.PositionDTO;
import com.gympass.app.api.models.dtos.RaceDTO;
import com.gympass.app.api.utils.DurationUtils;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
public class RaceDTOToPositionDTOConverter implements IPositionDTOConverter {

    @Override
    public PositionDTO convert(int position, RaceDTO raceDTO) {

        String driverId = raceDTO.getLapRecord().getDriver().getId();
        String driverName = raceDTO.getLapRecord().getDriver().getName();
        String completedLaps = String.valueOf(raceDTO.getLapRecord().getLapNumber());
        String totalDuration = DurationUtils.getFormattedStringFrom(raceDTO.getTotalDuration());
        String totalAverageSpeed = String.valueOf(raceDTO.getTotalAverageSpeed());
        LapRecordDTO bestLap = raceDTO.getBestLap();

        return new PositionDTO.Builder()
                .withPosition(position)
                .withDriverId(driverId)
                .withDriverName(driverName)
                .withCompletedLaps(completedLaps)
                .withTotalDuration(totalDuration)
                .withTotalAverageSpeed(totalAverageSpeed)
                .withBestLap(bestLap)
                .build();
    }
}
