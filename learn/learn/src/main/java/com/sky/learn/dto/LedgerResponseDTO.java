package com.sky.learn.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LedgerResponseDTO {
    Map<String, Integer> accountsCount; //symbolvsAccountsCount
    Map<String,Map<String,Integer>>  tranactionCodeVsQuantity; //symbol : { "buy" : 10000 , "sell" : 2000}

}
