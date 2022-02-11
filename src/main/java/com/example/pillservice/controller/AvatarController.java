package com.example.pillservice.controller;


import com.ps.core.exception.InputValidationException;
import com.ps.core.model.entity.PsUser;
import com.ps.core.model.web.AvatarWeb;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/user")
public class AvatarController {

    @PostMapping(value = "/avatar")
    public void updateUserAvatarImage(@AuthenticationPrincipal PsUser user,
                                      @RequestBody @Valid AvatarWeb avatar, BindingResult result) {


            if (result.hasErrors()) {
                throw new InputValidationException(result);
            }

    }

    @GetMapping(value = "/avatar")
    public AvatarWeb getUserAvatarImage(@AuthenticationPrincipal PsUser user) {

        return AvatarWeb.builder()
                .avatar(getImage())
                .build();
    }

    private String getImage() {
        return "data:image/jpeg;base64,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";
    }

}
