package com.gympass.app.api.converters;

import com.gympass.app.api.core.service.ILapRecordConverter;
import com.gympass.app.api.models.Driver;
import com.gympass.app.api.models.LapRecord;
import com.gympass.app.api.utils.DurationUtils;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
@Slf4j
public class StringToLapRecordConverter implements ILapRecordConverter {

    private static final int LAP_HOUR_POSITION = 0;
    private static final int DRIVER_POSITION = 1;
    private static final int LAP_NUMBER_POSITION = 2;
    private static final int LAP_TIME_POSITION = 3;
    // POSIÇÃO DE VELOCIDADE MÉDIA
    private static final int AVERAGE_LAP_SPEED_POSITION = 4;

    private static final String SPLIT_CHAR = "    ";
    private static final String DOT = ".";
    private static final String COMMA = ",";

    public LapRecord convert(String fileLine) {
        log.info("Method getFromFile invoked");
        if (!fileLine.isEmpty()) {

            List<String> data = Arrays.asList(fileLine.split(SPLIT_CHAR));
            StringToDriverConverter driverConverter = new StringToDriverConverter();

            LocalTime lapHour = LocalTime.parse(data.get(LAP_HOUR_POSITION).trim());
            Driver driver = driverConverter.convert(data.get(DRIVER_POSITION).trim());
            Integer lapNumber = Integer.valueOf(data.get(LAP_NUMBER_POSITION).trim());
            Duration lapDuration = DurationUtils.getDurationFrom(data.get(LAP_TIME_POSITION).trim());
            BigDecimal averageLapSpeed = new BigDecimal(data.get(AVERAGE_LAP_SPEED_POSITION).replace(COMMA, DOT).trim());

            LapRecord record = new LapRecord.Builder()
                    .withHour(lapHour)
                    .withDriver(driver)
                    .withLapNumber(lapNumber)
                    .withLapDuration(lapDuration)
                    .withAverageLapSpeed(averageLapSpeed)
                    .build();

            return record;
        }

        return null;
    }
}
