package com.gympass.app.api.gympass.converters;

import com.gympass.app.api.converters.LapRecordToLapRecordDTOConverter;
import com.gympass.app.api.gympass.utils.LapRecordTestUtils;
import com.gympass.app.api.models.LapRecord;
import com.gympass.app.api.models.dtos.LapRecordDTO;
import com.gympass.app.api.utils.DurationUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LapRecordToLapRecordDTOConverterTest {

    private LapRecord lapRecord;
    private LapRecordDTO lapRecordDTO;
    private LapRecordToLapRecordDTOConverter converter;

    @Test
    public void shouldConvertALapRecordWithoutNullValues(){
        givenALapRecordWithoutNullValues();
        givenALapRecordToLapRecordDTOConverter();
        whenConverting();
        shouldReturnARecordDTOWithoutNullValues();
        andWithSameValuesAsTheLapRecord();
    }

    @Test
    public void shouldConvertALapRecordWithNullValues(){
        givenALapRecordWithNullValues();
        givenALapRecordToLapRecordDTOConverter();
        whenConverting();
        shouldReturnARecordDTOWithTheSameValues();
    }


    private void givenALapRecordWithoutNullValues(){
        this.lapRecord = LapRecordTestUtils.getLapRecordWithoutNullValues();
    }

    private void givenALapRecordWithNullValues(){
        this.lapRecord = LapRecordTestUtils.getLapRecordWithNullValues();
    }

    private void givenALapRecordToLapRecordDTOConverter(){
        this.converter = new LapRecordToLapRecordDTOConverter();
    }

    private void whenConverting(){
        this.lapRecordDTO = this.converter.convert(lapRecord);
    }

    private void shouldReturnARecordDTOWithoutNullValues(){
        assertNotNull(lapRecordDTO.getAverageLapSpeed());
        assertNotNull(lapRecordDTO.getDriverId());
        assertNotNull(lapRecordDTO.getDriverName());
        assertNotNull(lapRecordDTO.getHour());
        assertNotNull(lapRecordDTO.getLapDuration());
        assertNotNull(lapRecordDTO.getLapNumber());
    }

    private void shouldReturnARecordDTOWithTheSameValues(){
        assertEquals("null", lapRecordDTO.getAverageLapSpeed());
        assertEquals(lapRecord.getDriver().getId(), lapRecordDTO.getDriverId());
        assertEquals(lapRecord.getDriver().getName(), lapRecordDTO.getDriverName());
        assertEquals("null", lapRecordDTO.getHour());
        assertEquals(DurationUtils.getFormattedStringFrom(lapRecord.getLapDuration()), lapRecordDTO.getLapDuration());
        assertEquals(String.valueOf(lapRecord.getLapNumber()), lapRecordDTO.getLapNumber());
    }


    private void andWithSameValuesAsTheLapRecord(){
        assertEquals(String.valueOf(lapRecord.getAverageLapSpeed()), lapRecordDTO.getAverageLapSpeed());
        assertEquals(lapRecord.getDriver().getId(), lapRecordDTO.getDriverId());
        assertEquals(lapRecord.getDriver().getName(), lapRecordDTO.getDriverName());
        assertEquals(String.valueOf(lapRecord.getHour()), lapRecordDTO.getHour());
        assertEquals(DurationUtils.getFormattedStringFrom(lapRecord.getLapDuration()), lapRecordDTO.getLapDuration());
        assertEquals(String.valueOf(lapRecord.getLapNumber()), lapRecordDTO.getLapNumber());
    }

}