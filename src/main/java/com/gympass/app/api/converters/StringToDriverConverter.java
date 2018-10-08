package com.gympass.app.api.converters;

import com.gympass.app.api.core.service.IDriverConverter;
import com.gympass.app.api.models.Driver;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
public class StringToDriverConverter implements IDriverConverter {

    private static final String SPLIT_CHAR = " – ";

    public Driver convert(String line) {
        String splitResult[] = line.split(SPLIT_CHAR.replaceAll(" – ", ""));
        return new Driver(splitResult[0], splitResult[1]);
    }
}
