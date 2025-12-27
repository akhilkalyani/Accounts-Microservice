package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
@Data
public class AccountsDTO {
    @Size(min = 10,max = 10,message = "Account no should be of 10 digit length")
    @Schema(
            description = "Account Number of Eazy Bank account", example = "3454433243"
    )
    private long accountNumber;

    @NotEmpty(message = "Account type should not be null or empty")
    @Schema(
            description = "Account type of Eazy Bank account", example = "Savings"
    )
    private String accountType;

    @NotEmpty(message = "Branch address type should not be null or empty")
    @Schema(
            description = "Eazy Bank branch address", example = "123 NewYork"
    )
    private String branchAddress;
}
