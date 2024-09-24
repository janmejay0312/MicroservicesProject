package com.janmejay.account.service.impl;

import com.janmejay.account.constants.AccountsConstants;
import com.janmejay.account.dto.CustomerDto;
import com.janmejay.account.entity.Account;
import com.janmejay.account.entity.Customer;
import com.janmejay.account.exceptions.AccountAlreadyExistException;
import com.janmejay.account.exceptions.CustomerAlreadyExistException;
import com.janmejay.account.mapper.AccountMapper;
import com.janmejay.account.mapper.CustomerMapper;
import com.janmejay.account.repository.AccountRepository;
import com.janmejay.account.repository.CustomerRepository;
import com.janmejay.account.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountRepository accountRepository;


    @Override
    public void createAccount(CustomerDto customerDto) {


        Customer customer = CustomerMapper.mapToCustomer(new Customer(),customerDto);

        Optional<Customer> customerIfPresent = customerRepository.findByMobileNumber(customer.getMobileNumber());

        if(customerIfPresent.isPresent()){
            throw  new CustomerAlreadyExistException(" Customer Already Exist with given mobile number");
        }

        Customer savedCustomer = customerRepository.save(customer);
        Account account = createAccount(customer);
        accountRepository.save(account);


    }

    private Account createAccount(Customer customer){

        Account account = new Account();

       // Optional<Account> accountNoIfPresent = accountRepository.findByAccountNo(customer.getCustomerId());



        account.setCustomerId(customer.getCustomerId());

        Random random = new Random();

        Long randomNumber = 1000000000L + random.nextInt(900000000);

//        Optional<Account> accountNoIfPresent = accountRepository.findByAccountNo(customer.getCustomerId());
//
//        if(accountNoIfPresent.isPresent())
//        {
//            throw new AccountAlreadyExistException("Account no Already Exist for ")
//        }

        account.setAccountNo(randomNumber);
        account.setAccountType(AccountsConstants.SAVINGS);
        account.setBranchAddress(AccountsConstants.ADDRESS);

    return  account;
    }
}
