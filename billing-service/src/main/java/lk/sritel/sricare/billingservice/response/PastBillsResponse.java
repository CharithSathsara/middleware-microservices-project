package lk.sritel.sricare.billingservice.response;

import lk.sritel.sricare.billingservice.model.Bill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PastBillsResponse {

    private String message;
    private HttpStatus status;
    private List<Bill> bills;

}
