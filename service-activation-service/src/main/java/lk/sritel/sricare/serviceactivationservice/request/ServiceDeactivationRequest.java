package lk.sritel.sricare.serviceactivationservice.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lk.sritel.sricare.serviceactivationservice.model.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDeactivationRequest {

    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("service_type")
    private String serviceType;

}
