package com.gympass.app.api.models.dtos;

import lombok.Data;

import java.util.List;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
@Data
public class ResultDTO {

    LapRecordDTO bestLapFromRace;
    List<PositionDTO> positions;

    public ResultDTO(LapRecordDTO bestLapFromRace, List<PositionDTO> positions) {
        this.bestLapFromRace = bestLapFromRace;
        this.positions = positions;
    }
}
