package com.sky.learn.dto;

import com.sky.learn.entity.Transactions;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@ToString
public class CustomerResponseDTO {

    private List<String> userNames;
    private List<Integer> accountId;
    private BigDecimal total;
    private List<Transactions> transactionsList;
}
