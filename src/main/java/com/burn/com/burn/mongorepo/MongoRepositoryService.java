package com.burn.com.burn.mongorepo;

import com.burn.com.burn.model.MongoDoc;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRepositoryService extends MongoRepository<MongoDoc,Integer>,MongoCustomService {
}
