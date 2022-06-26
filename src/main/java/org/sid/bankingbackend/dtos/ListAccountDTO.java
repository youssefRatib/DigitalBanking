package org.sid.bankingbackend.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ListAccountDTO {
    private int currentPage;
    private int totalPages;
    private int pageSize;
    private List<BankAccountDTO> bankingAccounts;
}
