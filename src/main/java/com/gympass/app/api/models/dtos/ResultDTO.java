package com.gympass.app.api.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
@Data
@AllArgsConstructor
public class ResultDTO {

    LapRecordDTO bestLapFromRace;
    List<PositionDTO> positions;
}
