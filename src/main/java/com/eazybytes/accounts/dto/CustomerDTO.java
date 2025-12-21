package com.eazybytes.accounts.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private String name;
    private String email;
    private int mobileNumber;
    private AccountsDTO accountsDto;
}
