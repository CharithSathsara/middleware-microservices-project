package lk.sritel.sricare.serviceactivationservice.service;

import lk.sritel.sricare.serviceactivationservice.model.ServiceActivation;
import lk.sritel.sricare.serviceactivationservice.model.ServiceType;
import lk.sritel.sricare.serviceactivationservice.repository.ServiceActivationRepository;
import lk.sritel.sricare.serviceactivationservice.response.ServiceActivationResponse;
import lk.sritel.sricare.serviceactivationservice.response.ServiceDeactivationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ServiceActivationService {

    @Autowired
    private ServiceActivationRepository activationRepository;
    
    public ServiceActivationResponse activateRoamingService(String userId) {

        try {

            ServiceActivation serviceActivation = new ServiceActivation();

            serviceActivation.setUserId(userId);
            serviceActivation.setServiceType(ServiceType.ROAMING);
            serviceActivation.setActivationDate(new Date());
            serviceActivation.setActivated(true);

            activationRepository.save(serviceActivation);

            return new ServiceActivationResponse("Roaming service activated successfully", HttpStatus.CREATED);

        } catch (Exception e) {
            return new ServiceActivationResponse("Error activating Roaming service: ", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ServiceDeactivationResponse deactivateRoamingService(String userId) {

        try {

            // Check if the service is already deactivated (if applicable)
            ServiceActivation existingActivation = activationRepository.findByUserIdAndServiceType(userId, ServiceType.ROAMING);
            if (existingActivation == null || !existingActivation.isActivated()) {
                return new ServiceDeactivationResponse("Roaming service is already deactivated or does not exist.", HttpStatus.BAD_REQUEST);
            }

            // Update the database to mark the service as deactivated
            existingActivation.setActivated(false);
            activationRepository.save(existingActivation);

            return new ServiceDeactivationResponse("Roaming service deactivated successfully",  HttpStatus.OK);

        } catch (Exception e) {
            return new ServiceDeactivationResponse("Failed to deactivate roaming service",  HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ServiceActivationResponse activateRingtonePersonalization(String userId) {

        try {

            ServiceActivation serviceActivation = new ServiceActivation();

            serviceActivation.setUserId(userId);
            serviceActivation.setServiceType(ServiceType.RINGTONE);
            serviceActivation.setActivationDate(new Date());
            serviceActivation.setActivated(true);

            activationRepository.save(serviceActivation);

            return new ServiceActivationResponse("Ringtone personalization service activated successfully", HttpStatus.CREATED);

        } catch (Exception e) {
            return new ServiceActivationResponse("Error activating Ringtone Personalization service: ", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ServiceDeactivationResponse deactivateRingtonePersonalization(String userId) {

        try {

            // Check if the service is already deactivated (if applicable)
            ServiceActivation existingActivation = activationRepository.findByUserIdAndServiceType(userId, ServiceType.RINGTONE);
            if (existingActivation == null || !existingActivation.isActivated()) {
                return new ServiceDeactivationResponse("Ringtone service is already deactivated or does not exist.", HttpStatus.BAD_REQUEST);
            }

            // Update the database to mark the service as deactivated
            existingActivation.setActivated(false);
            activationRepository.save(existingActivation);

            return new ServiceDeactivationResponse("Ringtone service deactivated successfully",  HttpStatus.OK);

        } catch (Exception e) {
            return new ServiceDeactivationResponse("Failed to deactivate ringtone service",  HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ServiceActivationResponse activateDataTopUp(String userId) {

        try {

            ServiceActivation serviceActivation = new ServiceActivation();

            serviceActivation.setUserId(userId);
            serviceActivation.setServiceType(ServiceType.DATA_TOP_UP);
            serviceActivation.setActivationDate(new Date());
            serviceActivation.setActivated(true);

            activationRepository.save(serviceActivation);

            return new ServiceActivationResponse("Data Top Up service activated successfully", HttpStatus.CREATED);

        } catch (Exception e) {
            return new ServiceActivationResponse("Error activating Data Top Up service: ", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ServiceDeactivationResponse deactivateDataTopUp(String userId) {

        try {

            // Check if the service is already deactivated (if applicable)
            ServiceActivation existingActivation = activationRepository.findByUserIdAndServiceType(userId, ServiceType.DATA_TOP_UP);
            if (existingActivation == null || !existingActivation.isActivated()) {
                return new ServiceDeactivationResponse("Data Top Up service is already deactivated or does not exist.", HttpStatus.BAD_REQUEST);
            }

            // Update the database to mark the service as deactivated
            existingActivation.setActivated(false);
            activationRepository.save(existingActivation);

            return new ServiceDeactivationResponse("Data Top Up service deactivated successfully",  HttpStatus.OK);

        } catch (Exception e) {
            return new ServiceDeactivationResponse("Failed to deactivate Data Top Up service",  HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
