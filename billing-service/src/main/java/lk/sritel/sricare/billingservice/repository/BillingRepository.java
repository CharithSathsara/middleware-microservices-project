package lk.sritel.sricare.billingservice.repository;

import lk.sritel.sricare.billingservice.model.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepository extends MongoRepository<Bill, String> {
    List<Bill> findByUserId(String userId);
}
