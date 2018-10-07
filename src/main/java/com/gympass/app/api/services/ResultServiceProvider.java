package com.gympass.app.api.services;

import com.gympass.app.api.core.service.ILapRecordDTOConverter;
import com.gympass.app.api.core.service.ILapRecordService;
import com.gympass.app.api.core.service.IPositionService;
import com.gympass.app.api.core.service.IResultService;
import com.gympass.app.api.models.LapRecord;
import com.gympass.app.api.models.dtos.LapRecordDTO;
import com.gympass.app.api.models.dtos.PositionDTO;
import com.gympass.app.api.models.dtos.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
@Slf4j
@Service
public class ResultServiceProvider implements IResultService {

    @Autowired
    private IPositionService positionService;

    @Autowired
    private ILapRecordService lapRecordServiceProvider;

    @Autowired
    private ILapRecordDTOConverter converter;

    @Override
    public ResultDTO getResult(List<LapRecord> lapRecords) {
        log.info("Method getResult invoked");
        List<PositionDTO> results = positionService.getPositions(lapRecords);

        LapRecordDTO bestLapFromRace = converter.convert(lapRecordServiceProvider.getBestLapFrom(lapRecords));

        return new ResultDTO(bestLapFromRace, results);
    }
}
