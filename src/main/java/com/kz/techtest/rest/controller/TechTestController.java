package com.kz.techtest.rest.controller;

import com.kz.techtest.helper.FutureMovementUtils;
import com.kz.techtest.model.FutureMovementModel;
import com.kz.techtest.rest.json.FutureMovementResponse;
import com.kz.techtest.service.FutureMovement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Slf4j
public class TechTestController {
    @Autowired
    private FutureMovement futureMovement;

    @PostMapping(value = "/upload/json", produces = "application/json")
    public ResponseEntity<List<FutureMovementResponse>> uploadFileJsonResponse(@RequestParam("file") MultipartFile file) {
        List<FutureMovementModel> futureMovementModels = futureMovement.handleFile(file);
        List<FutureMovementResponse> futureMovementResponses = FutureMovementUtils.domainToJson(futureMovementModels);
        return ResponseEntity.ok(futureMovementResponses);
    }
}
