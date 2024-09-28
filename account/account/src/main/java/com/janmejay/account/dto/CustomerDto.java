package com.janmejay.account.dto;

import com.janmejay.account.entity.Account;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CustomerDto {


    private String name;

    private String email;

    private String mobileNumber;

    private AccountsDto accountDto;
}
