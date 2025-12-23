package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.CustomerDTO;
import com.eazybytes.accounts.dto.ResponseDTO;
import com.eazybytes.accounts.service.IAccountsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
@Validated
public class AccountsController {
    private final IAccountsService accountsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAccount(
            @Valid
            @RequestBody CustomerDTO customerDTO) {
        accountsService.createAccount(customerDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDTO> fetchAccountDetailsByMobileNumber(
            @Min(value = 1000000000L, message = "Mobile no should be 10 digits long")
            @Max(value = 9999999999L, message = "Mobile no should be 10 digits long")
            @RequestParam
            int mobileNumber) {
        CustomerDTO customerDTO = accountsService.fetchAccountDetailsByMobileNumber(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(customerDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAccount(
            @Valid
            @RequestBody
            CustomerDTO customerDTO) {
        if (accountsService.updateAccount(customerDTO)) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteAccount(
            @Min(value = 1000000000L, message = "Mobile no should be 10 digits long")
            @Max(value = 9999999999L, message = "Mobile no should be 10 digits long")
            @RequestParam int mobileNumber){
        if (accountsService.deleteAccount(mobileNumber)) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDTO(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_DELETE));
        }
    }
}
