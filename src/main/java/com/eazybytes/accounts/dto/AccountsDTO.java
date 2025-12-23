package com.eazybytes.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AccountsDTO {
    @Size(min = 10,max = 10,message = "Account no should be of 10 digit length")
    private long accountNumber;

    @NotEmpty(message = "Account type should not be null or empty")
    private String accountType;

    @NotEmpty(message = "Branch address type should not be null or empty")
    private String branchAddress;
}
