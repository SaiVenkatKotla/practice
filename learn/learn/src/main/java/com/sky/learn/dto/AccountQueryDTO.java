package com.sky.learn.dto;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

@Data
@ToString
public class AccountQueryDTO {

    private ArrayList<String> product;
    private ArrayList<String> symbol;
}
