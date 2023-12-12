package com.kz.techtest.service.impl;

import com.kz.techtest.model.FutureMovementModel;
import com.kz.techtest.model.InputRecord;
import com.kz.techtest.service.FutureMovement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class FutureMovementImpl implements FutureMovement {
    private List<FutureMovementModel> futureMovementModels = new ArrayList<>();
    private Map<String, Double> resultMap = new HashMap<>();

    @Override
    public List<FutureMovementModel> handleFile(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                    .lines()
                    .forEach(this::handleLine);
            for (String key : resultMap.keySet()) {
                FutureMovementModel futureMovementModel = new FutureMovementModel();
                String clientInformation = key.split(",")[0];
                String productInformation = key.split(",")[1];

                futureMovementModel.setClientInformation(clientInformation);
                futureMovementModel.setProdcutInformation(productInformation);
                futureMovementModel.setTotalTransactionAmount(String.valueOf(resultMap.get(key)));
            }
            return futureMovementModels;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void handleLine(String line) {
        log.info(line);
        InputRecord inputRecord = new InputRecord(line.strip());

        String clientInformation = inputRecord.getClientType()
                .concat(inputRecord.getClientNumber())
                .concat(inputRecord.getAccountNumber())
                .concat(inputRecord.getSubaccountNumber());

        String productInformation = inputRecord.getExchangeCode()
                .concat(inputRecord.getProductGroupCode())
                .concat(inputRecord.getSymbol())
                .concat(inputRecord.getExpirationDate());

        String key = clientInformation.concat(",").concat(productInformation);
        Double value = Double.valueOf(inputRecord.getQuantityLong()) - Double.valueOf(inputRecord.getQuantityShort());

        if (resultMap.containsKey(key)) {
            resultMap.put(key, resultMap.get(key) + value);
        } else {
            resultMap.put(key, value);
        }
    }
}
