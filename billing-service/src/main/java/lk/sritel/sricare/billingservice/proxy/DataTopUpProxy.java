package lk.sritel.sricare.billingservice.proxy;

import lk.sritel.sricare.billingservice.model.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "data-top-up-service", url = "localhost:8000")
@FeignClient(name = "data-top-up-service")
public interface DataTopUpProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

}
