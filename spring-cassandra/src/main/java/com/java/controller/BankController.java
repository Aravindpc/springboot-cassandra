package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java.model.Bank;
import com.java.repository.BankRepository;

import java.util.List;

@RestController
@RequestMapping("/bankapi")
public class BankController {

    @Autowired
    BankRepository bankRepository;

    @PostMapping("/create")
    public Bank addBank(@RequestBody Bank bank){
        bankRepository.save(bank);
        return bank;
    }

    @GetMapping("/getbank/id")
    public ResponseEntity<Bank> findById(@PathVariable("id") Integer bankId){

        Bank bank = bankRepository.findById(bankId).get();

        return ResponseEntity.ok().body(bank);
    }

    @GetMapping("/getbanks")
    public List<Bank> getBanks(){
        return bankRepository.findAll();
    }

    @PutMapping("/updatebank/{id}")
    public ResponseEntity<Bank> updateBank(@PathVariable(value="id") Integer bankId, @RequestBody Bank banks){

        Bank bank = bankRepository.findById(bankId).get();

        bank.setBank_name(banks.getBank_name());
        final Bank updatedBank = bankRepository.save(bank);

        return ResponseEntity.ok(updatedBank);
    }

    @DeleteMapping("/deletebank/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable(value="id") Integer bankId) {

        Bank bank = bankRepository.findById(bankId).get();

        bankRepository.delete(bank);
        return ResponseEntity.ok().build();
    }
}
