package com.sky.learn.repository;


import com.sky.learn.entity.Accounts;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends MongoRepository<Accounts, ObjectId> {
}
