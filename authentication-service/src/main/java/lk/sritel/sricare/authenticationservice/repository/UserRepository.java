package lk.sritel.sricare.authenticationservice.repository;

import lk.sritel.sricare.authenticationservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByPhone(String phone);
}