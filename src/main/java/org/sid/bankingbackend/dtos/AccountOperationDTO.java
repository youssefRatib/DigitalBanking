package org.sid.bankingbackend.dtos;

import lombok.Data;
import org.sid.bankingbackend.enums.OperationType;


import java.util.Date;

@Data
public class AccountOperationDTO {
    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType operationType;
    private String description;
}

