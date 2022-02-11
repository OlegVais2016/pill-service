package com.example.pillservice.controller;

import com.ps.core.exception.AuthenticationException;
import com.ps.core.model.web.login.UserLoginWebRequest;
import com.ps.core.model.web.login.UserLoginWebResponse;
import com.ps.core.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/en/users")
public class LoginController {

    private LoginService loginService;

    @Autowired
    LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public UserLoginWebResponse login(@RequestBody @Valid UserLoginWebRequest loginWebRequest,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new AuthenticationException();
        }
        return loginService.login(loginWebRequest);
    }

    @PutMapping("/logout")
    public void logout(@RequestHeader(value = "Authorization") String token) {
        loginService.logout(token);
    }

}
