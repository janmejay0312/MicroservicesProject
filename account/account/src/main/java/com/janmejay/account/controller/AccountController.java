package com.janmejay.account.controller;

import com.janmejay.account.constants.AccountsConstants;
import com.janmejay.account.dto.CustomerDto;
import com.janmejay.account.dto.ResponseDto;
import com.janmejay.account.entity.Customer;
import com.janmejay.account.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    @Autowired
    IAccountService iAccountService;


    @PostMapping(value = "/account/save")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){

    Customer customer   =  iAccountService.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountsConstants.STATUS_201,AccountsConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccount(@RequestParam String mobileNumber){

        CustomerDto customerDto = iAccountService.fetchAccount(mobileNumber);

        return  ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }
@PutMapping("/update")
  public  ResponseEntity<ResponseDto> updateCustomer(@RequestBody CustomerDto customerDto){

        boolean isUpdated = iAccountService.updateCustomer(customerDto);
        ResponseEntity<ResponseDto> responseDto =  null;
        if(isUpdated)
            responseDto = ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
        else
            responseDto = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(AccountsConstants.STATUS_500,AccountsConstants.MESSAGE_500));

        return  responseDto;
  }

  @DeleteMapping("/delete")
  public ResponseEntity<ResponseDto> deleteAccount(@RequestParam String mobileNumber){
      boolean isDeleted = iAccountService.deleteCustomer(mobileNumber);
      ResponseEntity<ResponseDto> responseDto =  null;
      if(isDeleted)
          responseDto = ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
      else
          responseDto = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(AccountsConstants.STATUS_500,AccountsConstants.MESSAGE_500));

      return  responseDto;
  }
}
