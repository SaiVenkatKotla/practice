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
    private HashMap<String,TierAndDetails> tierAndDetails;
    private List<TierAndDetails> tier;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Integer> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Integer> accounts) {
        this.accounts = accounts;
    }

    public HashMap<String, TierAndDetails> getTierAndDetails() {
        return tierAndDetails;
    }

    public void setTierAndDetails(HashMap<String, TierAndDetails> tierAndDetails) {
        this.tierAndDetails = tierAndDetails;
    }

    public List<TierAndDetails> getTier() {
        return tier;
    }

    public void setTier(List<TierAndDetails> tier) {
        this.tier = tier;
    }
}
