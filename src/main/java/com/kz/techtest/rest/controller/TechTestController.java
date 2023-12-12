package com.kz.techtest.rest.controller;

import com.kz.techtest.helper.FutureMovementUtils;
import com.kz.techtest.model.FutureMovementModel;
import com.kz.techtest.rest.json.FutureMovementResponse;
import com.kz.techtest.service.FutureMovement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@RestController
public class TechTestController {
    @Autowired
    private FutureMovement futureMovement;

    @PostMapping(value = "/upload/json", produces = "application/json")
    public ResponseEntity<List<FutureMovementResponse>> uploadFileJsonResponse(@RequestParam("file") MultipartFile file) {
        List<FutureMovementModel> futureMovementModels = futureMovement.handleFile(file);
        List<FutureMovementResponse> futureMovementResponses = FutureMovementUtils.domainToJson(futureMovementModels);
        return ResponseEntity.ok(futureMovementResponses);
    }

    @PostMapping(value = "/upload/csv", produces = "application/json")
    public ResponseEntity<Resource> uploadFileCsvResponse(@RequestParam("file") MultipartFile file) {
        List<FutureMovementModel> futureMovementModels = futureMovement.handleFile(file);
        final InputStreamResource resource = new InputStreamResource(FutureMovementUtils.writreDataToCsv(futureMovementModels));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "result.csv")
                .body(resource);
    }
}
