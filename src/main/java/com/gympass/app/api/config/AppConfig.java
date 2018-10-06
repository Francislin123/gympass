package com.gympass.app.api.config;

import com.gympass.app.api.converters.LapRecordToLapRecordDTOConverter;
import com.gympass.app.api.converters.RaceDTOToPositionDTOConverter;
import com.gympass.app.api.converters.StringToDriverConverter;
import com.gympass.app.api.converters.StringToLapRecordConverter;
import com.gympass.app.api.readers.LogReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
@Configuration
public class AppConfig {

    @Bean
    public LogReader logReader() {
        return new LogReader();
    }

    @Bean
    public StringToDriverConverter driverConverter(){
        return new StringToDriverConverter();
    }

    @Bean
    public StringToLapRecordConverter stringToLapRecordConverter(){
        return new StringToLapRecordConverter();
    }

    @Bean
    public LapRecordToLapRecordDTOConverter lapRecordToLapRecordDTOConverter (){
        return new LapRecordToLapRecordDTOConverter();
    }

    @Bean
    public RaceDTOToPositionDTOConverter raceDTOToPositionDTOConverter(){
        return new RaceDTOToPositionDTOConverter();
    }
}
