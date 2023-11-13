package lk.sritel.sricare.billingservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "bill")
@Data
public class Bill {

    @Id
    private String id;
    private String userId;
    private double amount;
    private boolean isPaid;

}
