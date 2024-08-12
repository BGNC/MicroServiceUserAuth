package com.bgnc.repository;

import com.bgnc.document.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserProfile,String> {
}
