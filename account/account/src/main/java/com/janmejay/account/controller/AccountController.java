package com.janmejay.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AccountController {

    @GetMapping("/welcome")
    public String sayHello(){
        return "Hello Janmejay";
    }
}
