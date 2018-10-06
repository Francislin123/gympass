package com.gympass.app.api.core.service;

import com.gympass.app.api.models.LapRecord;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
public interface ILapRecordConverter {
    LapRecord convert(String fileLine);
}
