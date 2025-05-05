package com.sky.learn.serviceimpl;

import com.sky.learn.dto.AccountQueryDTO;
import com.sky.learn.dto.AccountsDTO;
import com.sky.learn.dto.AccountsResponseDTO;
import com.sky.learn.entity.Accounts;
import com.sky.learn.repository.AccountsRepository;
import com.sky.learn.service.AccountService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


import java.util.*;
import java.util.stream.Collectors;

import static com.sky.learn.constants.LearnConstants.ALL;

@Service
public class AccountServiceImpl implements AccountService {


    private final AccountsRepository accountsRepository;


    private static final ModelMapper mapper = new ModelMapper();

    public AccountServiceImpl(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @Override
    public AccountsDTO findAccountById(String id) {
        Optional<Accounts> accounts = accountsRepository.findById(new ObjectId((id)));
        return mapper.map(accounts, AccountsDTO.class);
    }

    @Override
    public AccountsResponseDTO findProductsByQuery(AccountQueryDTO accountQueryDTO) {
        // Retrieve all accounts
        List<Accounts> allAccounts = accountsRepository.findAll();

        // Prepare the response DTO
        AccountsResponseDTO responseDTO = new AccountsResponseDTO();

        // Use a Stream and groupingBy to count products directly
        Map<String, Integer> totalCount = allAccounts.stream()
                .flatMap(accounts -> accounts.getProducts().stream())
                .filter(product -> accountQueryDTO.getProduct().contains(ALL) || accountQueryDTO.getProduct().contains(product))
                .collect(Collectors.toMap(
                        product -> product, // Key is the product name
                        product -> 1,       // Initialize count as 1
                        Integer::sum        // Merge function to sum counts
                ));

        // Set the counts in the response DTO
        responseDTO.setProductsCount(totalCount);

        return responseDTO;
    }

}
