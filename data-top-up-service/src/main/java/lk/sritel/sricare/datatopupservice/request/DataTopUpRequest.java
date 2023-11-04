package lk.sritel.sricare.datatopupservice.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataTopUpRequest {

    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("amount")
    private double topUpAmount;

}
