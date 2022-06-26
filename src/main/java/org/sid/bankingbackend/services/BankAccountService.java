package org.sid.bankingbackend.services;

import org.sid.bankingbackend.dtos.*;
import org.sid.bankingbackend.exceptions.BalanceNotSufficientException;
import org.sid.bankingbackend.exceptions.BankAccountNotFoundException;
import org.sid.bankingbackend.exceptions.CustomerNotFoundException;


import java.util.List;
public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

    ListAccountDTO bankAccountList(int page, int size);

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;

    List<CustomerDTO> searchCustomers(String keyword);

    List<BankAccountDTO> bankAccountListByCustomer(Long customerId) throws CustomerNotFoundException;
}
