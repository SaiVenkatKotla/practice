package com.sky.learn.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "transactions")
public class Ledger {

    @Id
    private ObjectId _id;

    @Field("account_id")
    private Integer accountId;

    @Field("transaction_count")
    private Integer transactionCount;

    @Field("bucket_start_date")
    private Date bucketStartDate;

    @Field("bucket_end_date")
    private Date bucketEndDate;

    private List<Transactions> transactions;

}
