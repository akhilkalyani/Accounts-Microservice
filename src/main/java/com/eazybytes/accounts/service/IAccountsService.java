package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDTO;

public interface IAccountsService {

    /**
     * @param customerDTO
     * Create new account for Customer
     */
    void createAccount(CustomerDTO customerDTO);

    /**
     * @param mobileNumber
     * @return Customer Details
     */
    CustomerDTO fetchAccountDetailsByMobileNumber(int mobileNumber);

    /**
     * @param customerDTO
     * @return boolean as a status
     */
    boolean updateAccount(CustomerDTO customerDTO);

    /**
     * @param mobileNumber
     * @return boolean as a status
     */
    boolean deleteAccount(int mobileNumber);
}
