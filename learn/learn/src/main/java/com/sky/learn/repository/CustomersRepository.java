package com.sky.learn.repository;

import com.sky.learn.entity.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomersRepository extends MongoRepository<Customer, ObjectId> {

    Optional<Customer> findById(ObjectId id);

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByUsername(String username);
}
