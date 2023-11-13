package lk.sritel.sricare.billingservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BillRequest {

    private String userId;
    private double amount;

}
