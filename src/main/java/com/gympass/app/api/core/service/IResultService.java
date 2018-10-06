package com.gympass.app.api.core.service;

import com.gympass.app.api.models.LapRecord;
import com.gympass.app.api.models.dtos.ResultDTO;

import java.util.List;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
public interface IResultService {
    ResultDTO getResult(List<LapRecord> lapRecords);
}
