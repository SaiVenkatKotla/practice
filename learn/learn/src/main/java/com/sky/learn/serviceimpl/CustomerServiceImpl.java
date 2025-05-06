package com.sky.learn.serviceimpl;


import com.sky.learn.dto.CustomerResponseDTO;
import com.sky.learn.dto.QueryDTO;
import com.sky.learn.entity.*;
import com.sky.learn.repository.CustomersRepository;
import com.sky.learn.service.CustomerService;
import com.sky.learn.service.LedgerService;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sky.learn.constants.LearnConstants.ALL;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomersRepository customersRepository;

    private static final ModelMapper mapper = new ModelMapper();

    public CustomerServiceImpl(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Autowired
    LedgerService ledgerService;

    public Customer findById(String id) {
        Optional<Customer> customer = customersRepository.findById(new ObjectId(id));
        return customer.orElse(null);
    }

    public Customer findByEmail(String email) {
        Optional<Customer> customer = customersRepository.findByEmail(email);
        return customer.orElseThrow(() -> new RuntimeException("No Such Customer with email"));
    }

    public Customer findByUsername(String username) {
        Optional<Customer> customer = customersRepository.findByUsername(username);
        return customer.orElseThrow(() -> new RuntimeException("No Such Customer with UserName"));
    }

    @Override
    public BigDecimal findTotalByUsername(String username) {
        Customer customer = findByUsername(username);
        double sum = customer.getAccounts().stream().map(accounts -> ledgerService.findByAccountId(accounts)).
                flatMap(ledger -> ledger.getTransactions().stream()).mapToDouble(Transactions::getTotal).sum();
        return BigDecimal.valueOf(sum)
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public CustomerResponseDTO findTotalByQuery(QueryDTO queryDTO) {
        Customer customer = findByUsername(queryDTO.getUserName());
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        List<Integer> accountsStream = customer.getAccounts().stream()
                .filter(account -> Objects.equals(account, queryDTO.getAccountId() != null ? queryDTO.getAccountId() : account)).collect(Collectors.toList());
        double totalAmount = accountsStream.stream()
                .flatMap(account -> {
                    Ledger ledger = ledgerService.findByAccountId(account); // Avoid redundant calls
                    return ledger != null ? ledger.getTransactions().stream() : Stream.empty();
                })
                .filter(transaction -> queryDTO.getTransactionCode().equals((ALL)) || queryDTO.getTransactionCode().equals(transaction.getTransactionCode()))
                .mapToDouble(Transactions::getTotal)
                .sum();
        customerResponseDTO.setTotal(BigDecimal.valueOf(totalAmount).setScale(2, RoundingMode.HALF_UP));
        customerResponseDTO.setAccountId(accountsStream);
        customerResponseDTO.setTransactionsList(
                accountsStream.stream().flatMap(accounts -> ledgerService.findByAccountId(accounts).getTransactions().stream())
                        .filter(transaction -> queryDTO.getTransactionCode().equals((ALL)) || queryDTO.getTransactionCode().equals(transaction.getTransactionCode()))
                        .collect(Collectors.toList())
        );
        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO findTierAndDetails(QueryDTO queryDTO) {
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        List<Customer> customers = customersRepository.findAll();
        List<TierAndDetails> tierAndDetails = customers.stream().flatMap(customer -> customer.getTierAndDetails().values().stream()).toList();
        tierAndDetails.forEach(System.out::println);
        return customerResponseDTO;
    }


}
