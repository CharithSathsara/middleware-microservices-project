package lk.sritel.sricare.datatopupservice.service;

import lk.sritel.sricare.datatopupservice.model.DataTopUp;
import lk.sritel.sricare.datatopupservice.repository.DataTopUpRepository;
import lk.sritel.sricare.datatopupservice.request.DataTopUpRequest;
import lk.sritel.sricare.datatopupservice.response.DataTopUpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DataTopUpService {

    @Autowired
    private Environment environment;

    @Autowired
    private DataTopUpRepository dataTopUpRepository;

    public DataTopUpResponse topUpData(String userId, DataTopUpRequest dataTopUpRequest) {

        try {
            // Perform data top-up logic here
            // You can validate the data top-up request, update the user's data balance, etc.

            // For demonstration purposes, let's assume the data top-up is successful
            DataTopUp dataTopUp = new DataTopUp();

            dataTopUp.setUserId(userId);
            dataTopUp.setTopUpAmount(dataTopUpRequest.getTopUpAmount());
            dataTopUp.setTopUpDate(new Date());

            dataTopUpRepository.save(dataTopUp);

            return new DataTopUpResponse("Data Top-Up successful", HttpStatus.CREATED, environment.getProperty("local.server.port"));

        } catch (Exception e) {
            return new DataTopUpResponse("Error processing Data Top-Up", HttpStatus.INTERNAL_SERVER_ERROR, environment.getProperty("local.server.port"));
        }
    }

}
