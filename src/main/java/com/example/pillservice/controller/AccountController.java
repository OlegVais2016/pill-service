package com.example.pillservice.controller;

import com.ps.core.exception.InputValidationException;
import com.ps.core.model.entity.PsUser;
import com.ps.core.model.web.account.GetAccountResponse;
import com.ps.core.model.web.account.UpdateAccountRequest;
import com.ps.core.model.web.account.UpdateAccountResponse;
import com.ps.core.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/en/users")
public class AccountController {

    @Autowired
    UserAccountService userAccountService;

    @PostMapping("/account/update")
    public UpdateAccountResponse updateAccountData
            (@AuthenticationPrincipal PsUser user,
                    @RequestBody @Valid UpdateAccountRequest updateAccountRequest,
                    BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            throw new InputValidationException(bindingResult);
        }

        return userAccountService.updateAccount(updateAccountRequest,
                user);
    }

    @GetMapping("/account")
    public GetAccountResponse getUserAccount
            (@AuthenticationPrincipal PsUser user){

        return userAccountService.getAccount(user);
    }
}
