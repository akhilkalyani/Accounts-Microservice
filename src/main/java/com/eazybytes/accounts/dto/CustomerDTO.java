package com.eazybytes.accounts.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CustomerDTO {
    @NotEmpty(message = "Name cannot be null or empty")
    private String name;

    @NotEmpty(message = "Email cannot be null or empty")
    @Email(message = "Email should be valid email")
    private String email;

    @Min(value = 1000000000L, message = "Mobile no should be 10 digits long")
    @Max(value = 9999999999L, message = "Mobile no should be 10 digits long")
    private int mobileNumber;

    private AccountsDTO accountsDto;
}
