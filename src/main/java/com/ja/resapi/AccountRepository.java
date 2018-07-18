package com.ja.resapi;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Integer> {

        Optional<Account> findBySecondName(String secondName);
}
