package com.gympass.app.api.gympass.utils;

import com.gympass.app.api.converters.LapRecordToLapRecordDTOConverter;
import com.gympass.app.api.models.LapRecord;
import com.gympass.app.api.models.dtos.RaceDTO;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

public class RaceDTOTestUtils {

    public static RaceDTO getRaceDTOWithoutNullValues(){
        LapRecord bestLap = LapRecordTestUtils.getLapRecordWithoutNullValues();
        LapRecordToLapRecordDTOConverter lapRecordToLapRecordDTOConverter = new LapRecordToLapRecordDTOConverter();

        return new RaceDTO.Builder()
                .withBestLap(lapRecordToLapRecordDTOConverter.convert(bestLap))
                .withTotalAverageSpeed(new BigDecimal(Math.random()))
                .withTotalDuration(Duration.ofSeconds(LocalTime.now().getSecond()))
                .withLapRecord(bestLap)
                .withDelayAfterWinner(Duration.ofSeconds(LocalTime.now().getSecond()))
                .build();
    }

    public static RaceDTO getRaceDTOWithNullValues(){
        LapRecord bestLap = LapRecordTestUtils.getLapRecordWithNullValues();
        LapRecordToLapRecordDTOConverter lapRecordToLapRecordDTOConverter = new LapRecordToLapRecordDTOConverter();

        return new RaceDTO.Builder()
                .withBestLap(lapRecordToLapRecordDTOConverter.convert(bestLap))
                .withTotalAverageSpeed(new BigDecimal(Math.random()))
                .withTotalDuration(Duration.ofSeconds(LocalTime.now().getSecond()))
                .withLapRecord(bestLap)
                .withDelayAfterWinner(null)
                .build();
    }
}
