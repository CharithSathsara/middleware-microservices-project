package lk.sritel.sricare.datatopupservice.controller;

import lk.sritel.sricare.datatopupservice.model.CurrencyExchange;
import lk.sritel.sricare.datatopupservice.request.DataTopUpRequest;
import lk.sritel.sricare.datatopupservice.response.DataTopUpResponse;
import lk.sritel.sricare.datatopupservice.service.DataTopUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/data-top-up")
public class DataTopUpController {

    @Autowired
    private Environment environment;

    @Autowired
    private DataTopUpService dataTopUpService;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }

    @PostMapping("/user/{userId}/top-up")
    public DataTopUpResponse topUpData(@PathVariable String userId, @RequestBody DataTopUpRequest dataTopUpRequest) {
        return dataTopUpService.topUpData(userId, dataTopUpRequest);
    }

}
