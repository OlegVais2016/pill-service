package com.example.pillservice.controller.hc;



import com.ps.core.exception.InputValidationException;
import com.ps.core.model.entity.PsUser;
import com.ps.core.model.web.login.HcLoginResponse;
import com.ps.core.model.web.login.clalit.LoginClalitRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/en/users/clalit")
public class LoginClalitController {

    @PostMapping(value = "/login")
    public HcLoginResponse login(@AuthenticationPrincipal PsUser user,
                                 @RequestBody @Valid LoginClalitRequest userLoginClalitRequest,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputValidationException(bindingResult);
        }

        return HcLoginResponse.builder()
                .firstName("Alina")
                .lastName("Khomenker")
                .build();
    }

    @PutMapping(value = "/logout")
    public void logout(@RequestHeader(value = "Authorization") String token) {

    }
}
