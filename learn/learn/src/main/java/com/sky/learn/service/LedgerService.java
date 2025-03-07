package com.sky.learn.service;

import com.sky.learn.dto.LedgerQueryDTO;
import com.sky.learn.dto.LedgerResponseDTO;
import com.sky.learn.entity.Ledger;

public interface LedgerService {
    Ledger findById(String id);
    Ledger findByAccountId(Integer accountId);
    LedgerResponseDTO getSymbolDetails(LedgerQueryDTO queryDTO);
    LedgerResponseDTO findTransactionsByDate(LedgerQueryDTO queryDTO);
}
