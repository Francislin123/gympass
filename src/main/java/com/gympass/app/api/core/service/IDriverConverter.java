package com.gympass.app.api.core.service;

import com.gympass.app.api.models.Driver;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
public interface IDriverConverter {

    Driver convert(String line);
}
