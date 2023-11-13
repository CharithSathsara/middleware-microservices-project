package lk.sritel.sricare.datatopupservice.controller;

import lk.sritel.sricare.datatopupservice.request.DataTopUpRequest;
import lk.sritel.sricare.datatopupservice.response.DataTopUpResponse;
import lk.sritel.sricare.datatopupservice.service.DataTopUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data-top-up")
public class DataTopUpController {

    @Autowired
    private Environment environment;

    @Autowired
    private DataTopUpService dataTopUpService;

    @PostMapping("/user/{phone}/top-up")
    public DataTopUpResponse topUpData(@PathVariable String phone, @RequestBody DataTopUpRequest dataTopUpRequest) {
        return dataTopUpService.topUpData(phone, dataTopUpRequest);
    }

}
