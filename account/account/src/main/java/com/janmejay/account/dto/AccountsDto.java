package com.janmejay.account.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AccountsDto {


    @NotEmpty(message = "Account can not be null or empty value")
    @Pattern(regexp = "$|[0-9]{10}", message = "AccountNumber must be 10 digit")
    private Long accountNo;

    @NotEmpty(message = "AccountType must not be null or empty value")
    private String accountType;

    @NotEmpty(message = "BranchAddress must not be null or empty value")
    private String branchAddress;
}
