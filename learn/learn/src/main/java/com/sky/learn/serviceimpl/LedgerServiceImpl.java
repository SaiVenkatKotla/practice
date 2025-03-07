package com.sky.learn.serviceimpl;

import com.sky.learn.dto.LedgerQueryDTO;
import com.sky.learn.dto.LedgerResponseDTO;
import com.sky.learn.entity.Ledger;
import com.sky.learn.entity.Transactions;
import com.sky.learn.repository.LedgerRepository;
import com.sky.learn.service.LedgerService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.sky.learn.constants.LearnConstants.BOTH;

@Service
public class LedgerServiceImpl implements LedgerService {

    private final LedgerRepository ledgerRepository;

    public LedgerServiceImpl(LedgerRepository ledgerRepository) {
        this.ledgerRepository = ledgerRepository;
    }

    @Override
    public Ledger findById(String id) {
        Optional<Ledger> ledger = ledgerRepository.findById(new ObjectId(id));
        return ledger.orElse(null);
    }

    @Override
    public Ledger findByAccountId(Integer accountId) {
        Optional<Ledger> ledger = ledgerRepository.findByAccountId(accountId);
        return ledger.orElseThrow(() -> new RuntimeException("No Accounts with given accountId"));
    }

    @Override
    public LedgerResponseDTO getSymbolDetails(LedgerQueryDTO queryDTO) {
        LedgerResponseDTO responseDTO = new LedgerResponseDTO();
        List<Ledger> ledgerList = ledgerRepository.findAll();
        Map<String, HashMap<String, Integer>> transactionCodeVsQuantity = ledgerList.stream().flatMap(ledger -> ledger.getTransactions().stream())
                .filter(transactions -> queryDTO.getSymbols().contains(transactions.getSymbol()))
                .filter(transactions -> queryDTO.getTransactionCode().equals(BOTH) || queryDTO.getTransactionCode().equals(transactions.getTransactionCode()))
                .collect(Collectors.groupingBy(
                                Transactions::getSymbol,
                                Collectors.groupingBy(
                                        Transactions::getTransactionCode,
                                        Collectors.summingInt(Transactions::getAmount))
                        )
                ).entrySet().stream().collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> new HashMap<>(e.getValue())
                ));

        Map<String, Map<String,Integer>> t = ledgerList.stream().flatMap(ledger -> ledger.getTransactions().stream())
                .filter(transactions -> queryDTO.getSymbols().contains(transactions.getSymbol()))
                .filter(transactions -> queryDTO.getTransactionCode().equals(BOTH) || queryDTO.getTransactionCode().equals(transactions.getTransactionCode()))
                .collect(Collectors.groupingBy(
                                Transactions::getSymbol,
                                Collectors.groupingBy(
                                        Transactions::getTransactionCode,
                                        Collectors.summingInt(Transactions::getAmount))
                        )
                );
        System.out.println(t);


        responseDTO.setTranactionCodeVsQuantity(new HashMap<>(transactionCodeVsQuantity));
        return responseDTO;


    }

    @Override
    public LedgerResponseDTO findTransactionsByDate(LedgerQueryDTO queryDTO) {
        LedgerResponseDTO responseDTO = new LedgerResponseDTO();
        List<Ledger> ledgerList = ledgerRepository.findAll();

        return responseDTO;
    }
}
