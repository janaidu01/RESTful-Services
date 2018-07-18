package com.ja.resapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackageClasses = AccountController.class)
public class Application
{
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(AccountRepository accountRepository) {
        return (evt) -> Arrays.asList(
                "John Doe 1234, Jane Doe 1235, Jim Taylor 1236".split(","))
                .forEach(
                        a ->  {
                            String [] names = a.trim().split(" ");
                            Account account = new Account(names[0], names[1], names[2]);
                            accountRepository.save(account);
                        }
                );
    }
}
