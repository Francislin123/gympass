package com.gympass.app.api.readers;

import com.gympass.app.api.core.service.IFileReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
@Slf4j
public class LogReader implements IFileReader {

    public List<String> readFile(MultipartFile source) {
        log.info("Method readFile invoked");
        List<String> result = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(source.getInputStream()));
            result = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
