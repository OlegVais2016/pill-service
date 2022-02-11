package com.example.pillservice.controller;

import com.ps.core.exception.InputValidationException;
import com.ps.core.model.entity.PsUser;
import com.ps.core.model.web.ChangePasswordRequest;
import com.ps.core.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/en/users")
public class ChangePasswordController {

    @Autowired
    LoginService loginService;

    @PostMapping("/change-password")
    public void changePassword(@AuthenticationPrincipal PsUser user, @RequestBody @Valid ChangePasswordRequest userChangePassword,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InputValidationException(bindingResult);
        }

         loginService.changePassword( user, userChangePassword.getCurrentPassword(), userChangePassword.getNewPassword());

    }

}
