package com.sky.learn.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class LedgerQueryDTO {
    private List<String> symbols;
    private String transactionCode;
    private Date date;

}
