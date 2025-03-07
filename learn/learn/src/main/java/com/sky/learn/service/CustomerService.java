package com.sky.learn.service;

import com.sky.learn.dto.CustomerResponseDTO;
import com.sky.learn.dto.QueryDTO;
import com.sky.learn.entity.Customer;

import java.math.BigDecimal;

public interface CustomerService {

    Customer findById(String id);

    Customer findByEmail(String email);

    Customer findByUsername(String username);

    BigDecimal findTotalByUsername(String username);

    CustomerResponseDTO findTotalByQuery(QueryDTO queryDTO);

    CustomerResponseDTO findTierAndDetails(QueryDTO queryDTO);


}
