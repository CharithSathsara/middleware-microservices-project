package lk.sritel.sricare.datatopupservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "data_top_up")
public class DataTopUp {

    @Id
    private String id;
    private String userId;
    private double topUpAmount;
    private Date topUpDate;

}
