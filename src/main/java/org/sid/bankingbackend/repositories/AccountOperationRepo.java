package org.sid.bankingbackend.repositories;

import org.sid.bankingbackend.entities.AccountOperation;
import org.sid.bankingbackend.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepo extends JpaRepository<AccountOperation,Long> {
}
