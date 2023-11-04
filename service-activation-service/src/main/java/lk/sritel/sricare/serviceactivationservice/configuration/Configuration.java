package lk.sritel.sricare.serviceactivationservice.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
@ConfigurationProperties("service-activation-service")
public class Configuration {

    private int minimum;
    private int maximum;

}
