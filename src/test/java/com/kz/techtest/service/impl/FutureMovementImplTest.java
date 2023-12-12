package com.kz.techtest.service.impl;

import com.kz.techtest.model.FutureMovementModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FutureMovementImplTest {
    @InjectMocks
    private FutureMovementImpl futureMovement;

    @Test
    public void handleFileTest() {
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "test.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "315CL  432100020001SGXDC FUSGX NK    20100910JPY01B 0000000001 0000000000000000000060DUSD000000000030DUSD000000000000DJPY201008200012380     688032000092500000000             O\n".getBytes()
        );
        List<FutureMovementModel> futureMovementModels = futureMovement.handleFile(file);

        assertEquals(futureMovementModels.get(0).getClientInformation(), "CL  432100020001");
        assertEquals(futureMovementModels.get(0).getProdcutInformation(), "SGX FUNK    20100910");
        assertEquals(futureMovementModels.get(0).getTotalTransactionAmount(), "1.0");
    }
}
