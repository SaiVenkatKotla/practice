package com.sky.learn.repository;

import com.sky.learn.entity.Customer;
import com.sky.learn.entity.Ledger;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LedgerRepository extends MongoRepository<Ledger, ObjectId> {
    Optional<Ledger> findById(ObjectId id);

    Optional<Ledger> findByAccountId(Integer accountId);
}
