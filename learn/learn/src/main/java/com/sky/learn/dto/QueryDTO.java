package com.sky.learn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QueryDTO {

    private String userName;
    private String transactionCode;
    private Integer accountId;
    private List<String> tier;
}
