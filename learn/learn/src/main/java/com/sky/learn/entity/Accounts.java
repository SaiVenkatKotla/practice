package com.sky.learn.entity;


import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@ToString
@Document(collection = "accounts")
public class Accounts {

    @Id
    private ObjectId _id;
    private int accountId;
    private int limit;
    private List<String> products;

    public Accounts(ObjectId objectId, int i, int i1, List<String> of) {
        this._id = objectId;
        this.accountId = i;
        this.limit = i1;
        this.products = of;
    }
}
