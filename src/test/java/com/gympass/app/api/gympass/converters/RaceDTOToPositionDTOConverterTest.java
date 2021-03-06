package com.gympass.app.api.gympass.converters;

import com.gympass.app.api.converters.RaceDTOToPositionDTOConverter;
import com.gympass.app.api.gympass.utils.RaceDTOTestUtils;
import com.gympass.app.api.models.dtos.PositionDTO;
import com.gympass.app.api.models.dtos.RaceDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RaceDTOToPositionDTOConverterTest {

    private RaceDTO raceDTO;
    private RaceDTOToPositionDTOConverter converter;
    private PositionDTO positionDTO;

    @Test
    public void shouldConvertARaceDTOWithoutNullValues() {
        givenARaceDTOWithoutNullValues();
        givenARaceDTOToPositionDTOConverter();
        whenConverting();
        shouldReturnAPositionDTOWithoutNullValues();
        andWithSameValuesAsTheRaceDTO();
    }

    @Test
    public void shouldConvertARaceDTOWithNullValues() {
        givenARaceDTOWithNullValues();
        givenARaceDTOToPositionDTOConverter();
        whenConverting();
        shouldReturnAPositionDTOWithTheSameValues();
    }


    private void givenARaceDTOWithoutNullValues() {
        this.raceDTO = RaceDTOTestUtils.getRaceDTOWithoutNullValues();
    }

    private void givenARaceDTOWithNullValues() {
        this.raceDTO = RaceDTOTestUtils.getRaceDTOWithNullValues();
    }

    private void givenARaceDTOToPositionDTOConverter() {
        this.converter = new RaceDTOToPositionDTOConverter();
    }

    private void whenConverting() {
        this.positionDTO = this.converter.convert(1, raceDTO);
    }

    private void shouldReturnAPositionDTOWithoutNullValues() {
        assertNotNull(positionDTO.getBestLap().getLapNumber());
        assertNotNull(positionDTO.getBestLap().getLapDuration());
        assertNotNull(positionDTO.getBestLap().getHour());
        assertNotNull(positionDTO.getBestLap().getDriverName());
        assertNotNull(positionDTO.getBestLap().getDriverId());
        assertNotNull(positionDTO.getBestLap().getAverageLapSpeed());
        assertNotNull(positionDTO.getTotalAverageSpeed());
        assertNotNull(positionDTO.getCompletedLaps());
        assertNotNull(positionDTO.getDriverName());
        assertNotNull(positionDTO.getDriverId());
        assertNotNull(positionDTO.getPosition());
    }

    private void shouldReturnAPositionDTOWithTheSameValues() {
        assertEquals(String.valueOf(raceDTO.getBestLap().getLapNumber()), positionDTO.getBestLap().getLapNumber());
        assertEquals(String.valueOf(raceDTO.getBestLap().getLapDuration()), positionDTO.getBestLap().getLapDuration());
        assertEquals(String.valueOf(raceDTO.getBestLap().getHour()), positionDTO.getBestLap().getHour());
        assertEquals(String.valueOf(raceDTO.getBestLap().getDriverName()), positionDTO.getBestLap().getDriverName());
        assertEquals(String.valueOf(raceDTO.getBestLap().getDriverId()), positionDTO.getBestLap().getDriverId());
        assertEquals(String.valueOf(raceDTO.getBestLap().getAverageLapSpeed()), positionDTO.getBestLap().getAverageLapSpeed());
        assertEquals(String.valueOf(raceDTO.getTotalAverageSpeed()), positionDTO.getTotalAverageSpeed());
        assertEquals(String.valueOf(raceDTO.getLapRecord().getDriver().getName()), positionDTO.getDriverName());
        assertEquals(String.valueOf(raceDTO.getLapRecord().getDriver().getId()), positionDTO.getDriverId());
    }


    private void andWithSameValuesAsTheRaceDTO() {
        assertEquals(String.valueOf(raceDTO.getBestLap().getLapNumber()), positionDTO.getBestLap().getLapNumber());
        assertEquals(String.valueOf(raceDTO.getBestLap().getLapDuration()), positionDTO.getBestLap().getLapDuration());
        assertEquals(String.valueOf(raceDTO.getBestLap().getHour()), positionDTO.getBestLap().getHour());
        assertEquals(String.valueOf(raceDTO.getBestLap().getDriverName()), positionDTO.getBestLap().getDriverName());
        assertEquals(String.valueOf(raceDTO.getBestLap().getDriverId()), positionDTO.getBestLap().getDriverId());
        assertEquals(String.valueOf(raceDTO.getBestLap().getAverageLapSpeed()), positionDTO.getBestLap().getAverageLapSpeed());
        assertEquals(String.valueOf(raceDTO.getTotalAverageSpeed()), positionDTO.getTotalAverageSpeed());
        assertEquals(String.valueOf(raceDTO.getLapRecord().getDriver().getName()), positionDTO.getDriverName());
        assertEquals(String.valueOf(raceDTO.getLapRecord().getDriver().getId()), positionDTO.getDriverId());
    }
}