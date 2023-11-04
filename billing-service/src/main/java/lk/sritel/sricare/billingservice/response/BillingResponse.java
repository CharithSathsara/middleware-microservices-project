package lk.sritel.sricare.billingservice.response;

import lk.sritel.sricare.billingservice.model.Bill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingResponse {

    private String message;
    private HttpStatus status;
    private Bill bill;

}
