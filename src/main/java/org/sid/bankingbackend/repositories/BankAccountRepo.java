package org.sid.bankingbackend.repositories;

import org.sid.bankingbackend.entities.AccountOperation;
import org.sid.bankingbackend.entities.BankAccount;
import org.sid.bankingbackend.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepo extends JpaRepository<BankAccount,String> {
    List<BankAccount> findByCustomer(Customer customer);
    Page<BankAccount> findAll(Pageable pageable);
}
