package com.kz.techtest.service;

import com.kz.techtest.model.FutureMovementModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FutureMovement {
    List<FutureMovementModel> handleFile (MultipartFile file);
}
