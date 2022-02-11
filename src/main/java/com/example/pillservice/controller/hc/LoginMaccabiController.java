package com.example.pillservice.controller.hc;

import com.ps.core.exception.InputValidationException;
import com.ps.core.model.entity.PsUser;
import com.ps.core.model.web.login.HcLoginResponse;
import com.ps.core.model.web.login.maccabi.LoginMaccabiRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/en/users/maccabi/")
public class LoginMaccabiController {

    @PostMapping(value = "/login")
    public HcLoginResponse login(@AuthenticationPrincipal PsUser user,
                                 @RequestBody @Valid LoginMaccabiRequest userLoginMaccabiRequest,
                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InputValidationException(bindingResult);
        }

        return HcLoginResponse.builder()
                .firstName("Alina")
                .lastName("Khomenker")
                .build();
    }

}
