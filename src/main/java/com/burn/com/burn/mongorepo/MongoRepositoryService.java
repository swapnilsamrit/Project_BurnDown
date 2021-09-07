package com.burn.com.burn.mongorepo;

import com.burn.com.burn.model.MongoDoc;
import com.burn.com.burn.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.baeldung.repository")
public interface MongoRepositoryService extends MongoRepository<MongoDoc,Integer> {
}
