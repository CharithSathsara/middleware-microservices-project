package lk.sritel.sricare.billingservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "bill")
public class Bill {

    @Id
    private String id;
    private String userId;
    private double amount;
    private Date date;
    private boolean isPaid;

}
