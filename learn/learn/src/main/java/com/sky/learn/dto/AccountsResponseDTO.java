package com.sky.learn.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@ToString
public class AccountsResponseDTO {


    private Map<String,Integer> productsCount;
}
