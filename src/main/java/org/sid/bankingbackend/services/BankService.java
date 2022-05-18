package org.sid.bankingbackend.services;

import org.sid.bankingbackend.entities.BankAccount;
import org.sid.bankingbackend.entities.CurrentAccount;
import org.sid.bankingbackend.entities.SavingAccount;
import org.sid.bankingbackend.repositories.BankAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BankService {
    @Autowired
    private BankAccountRepo bankAccountRepo;
    public void consulter(){
        BankAccount bankAccount1 = bankAccountRepo.findById("2edeb8af-6313-4146-b4c0-45d7af556f97").orElse(null);
        if (bankAccount1!=null) {
            System.out.println("***********************************************************");
            System.out.println(bankAccount1.getClass().getSimpleName());
            System.out.println(bankAccount1.getId());
            System.out.println(bankAccount1.getBalance());
            System.out.println(bankAccount1.getStatus());
            System.out.println(bankAccount1.getCreatedAt());
            System.out.println(bankAccount1.getCustomer().getName());
            if (bankAccount1 instanceof CurrentAccount) {
                System.out.println(((CurrentAccount) bankAccount1).getOverDraft());
            } else if (bankAccount1 instanceof SavingAccount) {
                System.out.println(((SavingAccount) bankAccount1).getInterestRate());
            }
            bankAccount1.getAccountOperations().forEach(op -> {
                System.out.println(op.getOperationType() + "\t" + op.getOperationDate() + "\t" + op.getAmount());
            });
        }
    }
}
