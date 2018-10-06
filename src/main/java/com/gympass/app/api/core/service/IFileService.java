package com.gympass.app.api.core.service;

import com.gympass.app.api.models.LapRecord;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
public interface IFileService {
    List<LapRecord> getFromFile(MultipartFile file);
}
