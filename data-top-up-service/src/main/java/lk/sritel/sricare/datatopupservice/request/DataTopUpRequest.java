package lk.sritel.sricare.datatopupservice.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataTopUpRequest {

    @JsonProperty("phone")
    private String phone;
    @JsonProperty("amount")
    private double topUpAmount;

}
