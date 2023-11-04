package lk.sritel.sricare.serviceactivationservice.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ServiceActivationResponse {

    private String message;
    private HttpStatus status;

}
