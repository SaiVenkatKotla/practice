package com.sky.learn.dto;


import com.sky.learn.entity.Accounts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountsDTO {

    private ObjectId id;
    private int accountId;
    private int limit;
    private List<String> products;

}
