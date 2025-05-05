package com.sky.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Document(collection = "customers")
public class Customer {

    @Id
    private ObjectId _id;
    private String username;
    private String name;
    private String address;
    private Date birthdate;
    private String email;
    private boolean active;
    private List<Integer> accounts;
    @Field("tier_and_details")
    private HashMap<String, TierAndDetails> tierAndDetails;
    private List<TierAndDetails> tier;

    public Customer(String username, String name, String email) {
        this.username = username;
        this.name = name;
        this.email = email;
    }
}
