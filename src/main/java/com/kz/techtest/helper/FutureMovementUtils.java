package com.kz.techtest.helper;

import com.kz.techtest.model.FutureMovementModel;
import com.kz.techtest.rest.json.FutureMovementResponse;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FutureMovementUtils {
    public static List<FutureMovementResponse> domainToJson(List<FutureMovementModel> futureMovementModels) {

        List<FutureMovementResponse> futureMovementResponses = new ArrayList<>();
        for (FutureMovementModel futureMovementModel : futureMovementModels) {
            FutureMovementResponse futureMovementResponse = new FutureMovementResponse();

            futureMovementResponse.setClientInformation(futureMovementModel.getClientInformation());
            futureMovementResponse.setProdcutInformation(futureMovementModel.getProdcutInformation());
            futureMovementResponse.setTotalTransactionAmount(futureMovementModel.getTotalTransactionAmount());

            futureMovementResponses.add(futureMovementResponse);
        }

        return futureMovementResponses;
    }

    public static ByteArrayInputStream writreDataToCsv(final List<FutureMovementModel> futureMovementModels) {
        try (final ByteArrayOutputStream stream = new ByteArrayOutputStream();
            final CSVPrinter printer = new CSVPrinter(new PrintWriter(stream), CSVFormat.DEFAULT)) {
            final List<String> header = Arrays.asList("Client Information", "Product Information", "Total Transaction Amount");
            printer.printRecord(header);
            for (final FutureMovementModel futureMovementModel: futureMovementModels) {
                final List<String> data = Arrays.asList(
                        futureMovementModel.getClientInformation(),
                        futureMovementModel.getProdcutInformation(),
                        futureMovementModel.getTotalTransactionAmount()
                );
                printer.printRecord(data);
            }

            printer.flush();
            return new ByteArrayInputStream(stream.toByteArray());
        } catch (final IOException e) {
            throw new RuntimeException("Csv writing error: " + e.getMessage());
        }
    }
}
