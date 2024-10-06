package com.janmejay.account.dto;

import com.janmejay.account.entity.Account;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CustomerDto {

    @NotEmpty(message = "name can not be null or empty value")
    @Size(min = 5, max = 30, message = "name is not having valid length")
    private String name;

    @NotEmpty(message ="name can not be null or empty value")
    @Email(message = "Email should be a valid value")
    private String email;

    @Pattern( regexp = "$|[0-9]{10}", message = "mobile number should be 10 digit")
    private String mobileNumber;

    private AccountsDto accountDto;
}
