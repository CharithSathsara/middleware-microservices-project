package lk.sritel.sricare.datatopupservice.model;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class CurrencyExchange {

    private final Long id;
    private final String from;
    private final String to;
    private final BigDecimal conversionMultiple;
    private String environment;

}
