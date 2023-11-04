package lk.sritel.sricare.billingservice.controller;

import lk.sritel.sricare.billingservice.model.CurrencyConversion;
import lk.sritel.sricare.billingservice.proxy.DataTopUpProxy;
import lk.sritel.sricare.billingservice.response.BillingResponse;
import lk.sritel.sricare.billingservice.response.PastBillsResponse;
import lk.sritel.sricare.billingservice.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private DataTopUpProxy dataTopUpProxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
//        return new CurrencyConversion(1000L, from, to, BigDecimal.ONE, quantity, BigDecimal.ONE, "");

        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);

        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity
                ("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                        CurrencyConversion.class, uriVariables);

        CurrencyConversion currencyConversion = responseEntity.getBody();

        return new CurrencyConversion(currencyConversion.getId(),
                from, to, quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment()+ " " + "rest template");

    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        CurrencyConversion currencyConversion = dataTopUpProxy.retrieveExchangeValue(from, to);

        return new CurrencyConversion(currencyConversion.getId(),
                from, to, quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment()+ " " + "feign");

    }

    @Autowired
    private BillingService billingService;

//    @GetMapping("/current-bill/{userId}")
//    public BillingResponse getCurrentBill(@PathVariable String userId) {
//        return billingService.getCurrentBill(userId);
//    }

    @GetMapping("/past-bills/{userId}")
    public PastBillsResponse getPastBills(@PathVariable String userId) {
        return billingService.getPastBills(userId);
    }

}
