package lk.sritel.sricare.datatopupservice.repository;

import lk.sritel.sricare.datatopupservice.model.DataTopUp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataTopUpRepository extends MongoRepository<DataTopUp, String> {
}
