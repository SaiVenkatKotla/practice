package com.sky.learn.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Transactions {

    @Field("date")
    private Date date;
    @Field("amount")
    private Integer amount;
    @Field("transaction_code")
    private String transactionCode;
    @Field("symbol")
    private String symbol;
    @Field("price")
    private Double price;
    @Field("total")
    private Double total;
}
