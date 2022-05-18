package org.sid.bankingbackend;

import org.sid.bankingbackend.entities.*;
import org.sid.bankingbackend.enums.AccountStatus;
import org.sid.bankingbackend.enums.OperationType;
import org.sid.bankingbackend.repositories.AccountOperationRepo;
import org.sid.bankingbackend.repositories.BankAccountRepo;
import org.sid.bankingbackend.repositories.CustomerRepo;
import org.sid.bankingbackend.services.BankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingBackendApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BankService bankService){
        return args -> {
            bankService.consulter();
        };
    }
    //@Bean
    CommandLineRunner start(CustomerRepo customerRepo, BankAccountRepo bankAccountRepo, AccountOperationRepo accountOperationRepo){
        return args -> {
            Stream.of("youssef","yassine","zakaria").forEach(name->{
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                customerRepo.save(customer);
            });
            customerRepo.findAll().forEach(customer -> {
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setBalance(Math.random()*90000);
                currentAccount.setCreatedAt(new Date());
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setCustomer(customer);
                currentAccount.setOverDraft(9000);
                bankAccountRepo.save(currentAccount);

                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setId(UUID.randomUUID().toString());
                savingAccount.setBalance(Math.random()*90000);
                savingAccount.setCreatedAt(new Date());
                savingAccount.setStatus(AccountStatus.CREATED);
                savingAccount.setCustomer(customer);
                savingAccount.setInterestRate(5.5);
                bankAccountRepo.save(savingAccount);
            });
            bankAccountRepo.findAll().forEach(bankAccount -> {
                for (int i = 0;i<5;i++){
                    AccountOperation accountOperation = new AccountOperation();
                    accountOperation.setOperationDate(new Date());
                    accountOperation.setAmount(Math.random()*12000);
                    accountOperation.setOperationType(Math.random()>0.5? OperationType.CREDIT:OperationType.DEBIT);
                    accountOperation.setBankAccount(bankAccount);
                    accountOperationRepo.save(accountOperation);
                }
            });
        };
    }

}
