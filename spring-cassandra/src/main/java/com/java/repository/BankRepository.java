package com.java.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.java.model.Bank;

public interface BankRepository extends CassandraRepository<Bank, Integer> {
}
