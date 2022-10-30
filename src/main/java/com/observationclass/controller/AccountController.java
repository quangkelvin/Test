package com.observationclass.controller;

import com.observationclass.entity.Account;
import com.observationclass.model.ApiResponse;
import com.observationclass.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createAccount(@RequestBody @Valid Account accountRequest){
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
        return ResponseEntity.ok().body(accountService.createAccount(accountRequest));

    }
    @GetMapping("/list")
    public ResponseEntity<ApiResponse> listAccount(){
        return ResponseEntity.ok().body(accountService.listAccount());

    }
}
