package com.burn.com.burn.consumer;

import com.burn.com.burn.model.MongoDoc;
import com.burn.com.burn.mongorepo.MongoCustomService;
import com.burn.com.burn.mongorepo.MongoRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    MongoRepositoryService mongoRepositoryService;
    @Override
    public void insert(String data) {
        MongoDoc mongoDoc=new MongoDoc();
        mongoDoc.setId(1001);
        mongoDoc.setDomain(data);
       MongoDoc doc= mongoRepositoryService.save(mongoDoc);
       if (Objects.nonNull(doc)){
           System.out.println("Data Inserted in Mongo DB Successfully!");
           System.out.println("Data is "+doc.toString());
       }
    }
}
