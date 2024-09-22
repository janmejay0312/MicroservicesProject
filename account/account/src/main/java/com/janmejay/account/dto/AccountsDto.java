package com.janmejay.account.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class AccountsDto {


    private Long accountNo;

    private String accountType;

    private String branchAddress;
}
