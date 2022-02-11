package com.example.pillservice.controller;


import com.ps.core.exception.InputValidationException;
import com.ps.core.model.web.RegistrationRequest;
import com.ps.core.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/en/users/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/request")
    public void registration
            (@RequestBody @Valid RegistrationRequest userRegistrationRequest,
             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InputValidationException(bindingResult);
        }
        registrationService.registrationUser(userRegistrationRequest);
    }

    @GetMapping(value = "/confirmation/{confirmation_link}")
    public void confirmation(@PathVariable("confirmation_link") String confirmationLink) {
        registrationService.registrationConfirmation(confirmationLink);
    }
}
