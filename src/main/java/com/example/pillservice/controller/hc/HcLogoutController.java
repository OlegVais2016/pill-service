package com.example.pillservice.controller.hc;

import com.ps.core.model.entity.PsUser;
import com.ps.core.service.HcUserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/en/users/hc")
public class HcLogoutController {

    @Autowired
    private HcUserSessionService userSessionService;

    @PutMapping("/logout")
    public void logout(@AuthenticationPrincipal PsUser user) {
        userSessionService.delete(user);
    }
}
