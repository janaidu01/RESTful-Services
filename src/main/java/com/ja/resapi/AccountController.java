package com.ja.resapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/account-project/rest/account/json")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    public List<Account> retriveAllaccounts() {
        return (List<Account>) accountRepository.findAll();
    }

    @PostMapping
    public Response createAccount(@RequestBody Account account) {
        Account savedAccount = accountRepository.save(account);
        return new Response("account has been successfully added");
    }

    @DeleteMapping("/{id}")
    public Response deleteAccount(@PathVariable int id) {
        accountRepository.findById(id)
                .orElseThrow(() ->  new AccounNotFoundException(String.valueOf(id)));

        accountRepository.deleteById(id);
        return new Response("account successfully deleted");
    }

    @GetMapping("/sn/{secondName}")
    public Account retriveAccountBySecondName(@PathVariable String secondName) {
        return this.accountRepository.findBySecondName(secondName)
                .orElseThrow(() -> new AccounNotFoundException(secondName));
    }

}