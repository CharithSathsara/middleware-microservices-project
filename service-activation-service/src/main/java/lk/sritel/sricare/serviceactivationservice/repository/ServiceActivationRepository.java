package lk.sritel.sricare.serviceactivationservice.repository;

import lk.sritel.sricare.serviceactivationservice.model.ServiceActivation;
import lk.sritel.sricare.serviceactivationservice.model.ServiceType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceActivationRepository extends MongoRepository<ServiceActivation, String> {
    ServiceActivation findByUserIdAndServiceType(String userId, ServiceType roaming);
}
