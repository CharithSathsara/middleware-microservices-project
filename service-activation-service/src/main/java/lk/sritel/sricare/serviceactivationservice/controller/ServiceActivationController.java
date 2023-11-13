package lk.sritel.sricare.serviceactivationservice.controller;

import lk.sritel.sricare.serviceactivationservice.configuration.Configuration;
import lk.sritel.sricare.serviceactivationservice.model.Limits;
import lk.sritel.sricare.serviceactivationservice.response.ServiceActivationResponse;
import lk.sritel.sricare.serviceactivationservice.response.ServiceDeactivationResponse;
import lk.sritel.sricare.serviceactivationservice.service.ServiceActivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telco-service")
public class ServiceActivationController {

    @Autowired
    private Configuration configuration;

    @Autowired
    private ServiceActivationService activationService;

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }

    @PostMapping("/roaming/activate/{userId}")
    public ServiceActivationResponse activateRoamingService(@PathVariable String userId) {
        System.out.println("ROAMING");
        return activationService.activateRoamingService(userId);
    }

    @PostMapping("/roaming/deactivate/{userId}")
    public ServiceDeactivationResponse deactivateRoamingService(@PathVariable String userId) {
        return activationService.deactivateRoamingService(userId);
    }

    @PostMapping("/ringtone/activate/{userId}")
    public ServiceActivationResponse activateRingtonePersonalization(@PathVariable String userId) {
        return activationService.activateRingtonePersonalization(userId);
    }

    @PostMapping("/ringtone/deactivate/{userId}")
    public ServiceDeactivationResponse deactivateRingtonePersonalization(@PathVariable String userId) {
        return activationService.deactivateRingtonePersonalization(userId);
    }

    @PostMapping("/data-top-up/activate/{userId}")
    public ServiceActivationResponse activateDataTopUp(@PathVariable String userId) {
        return activationService.activateDataTopUp(userId);
    }

    @PostMapping("/data-top-up/deactivate/{userId}")
    public ServiceDeactivationResponse deactivateDataTopUp(@PathVariable String userId) {
        return activationService.deactivateDataTopUp(userId);
    }

}
