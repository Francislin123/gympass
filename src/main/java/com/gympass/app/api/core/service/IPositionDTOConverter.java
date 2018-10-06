package com.gympass.app.api.core.service;

import com.gympass.app.api.models.dtos.PositionDTO;
import com.gympass.app.api.models.dtos.RaceDTO;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
public interface IPositionDTOConverter {

    PositionDTO convert(int position, RaceDTO raceDTO);
}
