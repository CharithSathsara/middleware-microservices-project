package lk.sritel.sricare.ringtonepersonalizationservice.repository;

import lk.sritel.sricare.ringtonepersonalizationservice.model.Ringtone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RingtoneRepository extends MongoRepository<Ringtone, String> {
    Ringtone findByUserId(String userId);
}
