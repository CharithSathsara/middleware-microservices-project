package lk.sritel.sricare.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/telco-service/**")
                        .uri("lb://service-activation-service"))
                .route(p -> p.path("/data-top-up/**")
                        .uri("lb://data-top-up-service"))
                .route(p -> p.path("/ringtone-personalization/**")
                        .uri("lb://ringtone-personalization-service"))
                .route(p -> p.path("/billing/**")
                        .uri("lb://billing-service"))
                .build();
    }

}
