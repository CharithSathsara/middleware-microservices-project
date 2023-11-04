package lk.sritel.sricare.serviceactivationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "service_activation")
public class ServiceActivation {

    @Id
    private String id;
    private String userId;
    private ServiceType serviceType;
    private Date activationDate;
    private boolean isActivated;

}
