package com.gympass.app.api.services;

import com.gympass.app.api.core.service.IFileReader;
import com.gympass.app.api.core.service.IFileService;
import com.gympass.app.api.core.service.ILapRecordConverter;
import com.gympass.app.api.models.LapRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
@Service
public class FileServiceProvider implements IFileService {

    @Autowired
    private IFileReader logReader;

    @Autowired
    private ILapRecordConverter converter;

    public List<LapRecord> getFromFile(MultipartFile file){

        List<String> fileLines = logReader.readFile(file);

        return fileLines.stream()
                .skip(1)
                .map(line -> converter.convert(line)).collect(Collectors.toList());
    }
}
