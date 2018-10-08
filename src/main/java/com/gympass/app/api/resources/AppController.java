package com.gympass.app.api.resources;

import com.gympass.app.api.core.service.IFileService;
import com.gympass.app.api.core.service.IResultService;
import com.gympass.app.api.models.dtos.ResultDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Francislin Dos Reis on 06/10/18.
 */
@Api
@RestController
public class AppController {

    @Autowired
    private IFileService fileService;

    @Autowired
    private IResultService resultService;

    @ApiOperation(value = "Upload a txt file",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully imported text file", response = ResponseEntity.class)})
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = {"multipart/form-data", MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResultDTO> handleFileUpload(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(resultService.getResult(fileService.getFromFile(file)));
    }
}
