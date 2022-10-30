package com.observationclass.service;

import com.observationclass.entity.Account;
import com.observationclass.entity.Role;
import com.observationclass.model.ApiResponse;
import com.observationclass.repository.AccountRepository;
import com.observationclass.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleRepository roleRepository;
  public ApiResponse createAccount(Account accountRequest){
    setAccount(accountRequest);
    return new ApiResponse("Http_200","Success",null);

  }
  public ApiResponse listAccount(){
      List<Account> lstAccount =accountRepository.findAll();
      return new ApiResponse("http 200","success",null);

  }



    public void setAccount(Account accountRequest){
        Account newAccount = new Account();
        newAccount.setUserName(accountRequest.getUserName());
        newAccount.setEmail(accountRequest.getEmail());
        newAccount.setRegist();

        for (Role r:accountRequest.getRoles()){
            System.out.println(r.getId()+"...........");
        }
        System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        try {
            newAccount.getRoles().addAll(accountRequest.getRoles().stream().map(r -> {
                System.out.println(r.getId() + "   ----- " );
                Role role = roleService.findRoleById(r.getId());
                role.getAccounts().add(newAccount);
                return role;

            }).collect(Collectors.toList()));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        accountRepository.save(newAccount);

    }
}
