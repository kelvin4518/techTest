package com.kz.techtest.helper;

import com.kz.techtest.model.FutureMovementModel;
import com.kz.techtest.rest.json.FutureMovementResponse;

import java.util.ArrayList;
import java.util.List;

public class FutureMovementUtils {
    public static List<FutureMovementResponse> domainToJson(List<FutureMovementModel> futureMovementModels) {
        List<FutureMovementResponse> futureMovementResponses = new ArrayList<>();
        for (FutureMovementModel futureMovementModel : futureMovementModels) {
            FutureMovementResponse futureMovementResponse = new FutureMovementResponse();
            futureMovementResponses.add(futureMovementResponse);
        }

        return futureMovementResponses;
    }
}
