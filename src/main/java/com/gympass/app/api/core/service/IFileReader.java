package com.gympass.app.api.core.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
public interface IFileReader {

    List<String> readFile(MultipartFile source);
}
