package lk.sritel.sricare.serviceactivationservice.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDeactivationResponse {

    private String message;
    private HttpStatus status;

}
