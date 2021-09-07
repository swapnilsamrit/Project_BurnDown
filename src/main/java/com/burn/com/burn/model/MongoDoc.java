package com.burn.com.burn.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "MongoDoc")
public class MongoDoc {

    @Id
    private long id;

    @Indexed(unique = true)
    private String domain;

}
