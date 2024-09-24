package com.janmejay.account.mapper;

import com.janmejay.account.dto.AccountsDto;
import com.janmejay.account.dto.CustomerDto;
import com.janmejay.account.entity.Account;
import com.janmejay.account.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDtoDto){

        customerDtoDto.setName(customer.getName());
        customerDtoDto.setEmail(customer.getEmail());
        customerDtoDto.setMobileNumber(customer.getMobileNumber());
        return customerDtoDto;
    }

    public static  Customer mapToCustomer(Customer customer, CustomerDto customerDtoDto){

        customer.setName(customerDtoDto.getName());
        customer.setEmail(customerDtoDto.getEmail());
        customer.setMobileNumber(customerDtoDto.getMobileNumber());
        return customer;
    }
}
