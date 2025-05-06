package com.sky.learn.controller;

import com.sky.learn.dto.LedgerQueryDTO;
import com.sky.learn.dto.LedgerResponseDTO;
import com.sky.learn.entity.Ledger;
import com.sky.learn.serviceimpl.LedgerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LedgerController {

    @Autowired
    LedgerServiceImpl ledgerService;

    @GetMapping("/ledger/{id}")
    public ResponseEntity<Ledger> getLedgerById(@PathVariable String id) {
        return ResponseEntity.ok(ledgerService.findById(id));
    }

    @GetMapping("/ledger/account/{accountId}")
    public ResponseEntity<Ledger> getLedgerByAccountId(@PathVariable Integer accountId) {
        return ResponseEntity.ok(ledgerService.findByAccountId(accountId));
    }

    @PostMapping("/ledger/symbol")
    public ResponseEntity<LedgerResponseDTO> getSymbolDetails(@RequestBody LedgerQueryDTO symbol){
        return ResponseEntity.ok(ledgerService.getSymbolDetails(symbol));
    }

    @PostMapping("/ledger/date")
    public ResponseEntity<LedgerResponseDTO> getTransactionsByDate(@RequestBody LedgerQueryDTO queryDTO){
        return ResponseEntity.ok(ledgerService.findTransactionsByDate(queryDTO));
    }
}
