package lk.sritel.sricare.ringtonepersonalizationservice.response;

import lk.sritel.sricare.ringtonepersonalizationservice.model.Ringtone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RingtonePersonalizationResponse {

    private String message;
    private HttpStatus status;
    private Ringtone ringtone;

}
