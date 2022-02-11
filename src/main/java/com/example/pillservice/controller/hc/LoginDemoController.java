package com.example.pillservice.controller.hc;

import com.ps.core.exception.InputValidationException;
import com.ps.core.model.entity.PsUser;
import com.ps.core.model.entity.type.HcType;
import com.ps.core.model.web.login.HcLoginResponse;
import com.ps.core.model.web.login.demo.LoginDemoRequest;
import com.ps.core.service.hc.login.HcLoginService;
import com.ps.core.service.system.HcBeanResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/en/users/demo/")
public class LoginDemoController {

    @Autowired
    private HcBeanResolver beanResolver;

    @PostMapping(value = "/login")
    public HcLoginResponse login(@AuthenticationPrincipal PsUser user,
                                 @RequestBody @Valid LoginDemoRequest loginRequest,
                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InputValidationException(bindingResult);
        }

        HcLoginService loginService = beanResolver.resolve(HcLoginService.class, HcType.DEMO);
        return loginService.login(loginRequest, user);
    }

}
