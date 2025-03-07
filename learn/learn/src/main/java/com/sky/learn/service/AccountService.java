package com.sky.learn.service;

import com.sky.learn.dto.AccountQueryDTO;
import com.sky.learn.dto.AccountsDTO;
import com.sky.learn.dto.AccountsResponseDTO;

public interface AccountService {

    AccountsDTO findAccountById(String id);

    AccountsResponseDTO findProductsByQuery(AccountQueryDTO accountQueryDTO);



}
