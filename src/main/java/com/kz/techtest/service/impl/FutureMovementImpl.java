package com.kz.techtest.service.impl;

import com.kz.techtest.model.FutureMovementModel;
import com.kz.techtest.service.FutureMovement;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class FutureMovementImpl implements FutureMovement {
    @Override
    public List<FutureMovementModel> handleFile(MultipartFile file) {
        return null;
    }
}
