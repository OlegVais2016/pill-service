package com.example.pillservice.controller.hc;

import com.ps.core.exception.HcAuthenticationException;
import com.ps.core.exception.InputValidationException;
import com.ps.core.model.entity.HcUserSession;
import com.ps.core.model.entity.PsUser;
import com.ps.core.model.web.form17.Form17ShortWeb;
import com.ps.core.model.web.form17.FormSeventeenFullWeb;
import com.ps.core.model.web.form17.FormSeventeenListWeb;
import com.ps.core.model.web.form17.FormSeventeenRequest;
import com.ps.core.service.HcUserSessionService;
import com.ps.core.service.hc.form.HcFormSeventeenService;
import com.ps.core.service.system.HcBeanResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/en/users")
public class FormSeventeenController {

    @Autowired
    private HcUserSessionService hcUserSessionService;

    @Autowired
    private HcBeanResolver beanResolver;

    @GetMapping(value = "/forms-17")
    public FormSeventeenListWeb getForms17List(@AuthenticationPrincipal PsUser user,
                                               @RequestParam(value = "page") Integer page,
                                               @RequestParam(value = "size") Integer size) {
        List<Form17ShortWeb> forms = new ArrayList<>();
        forms.add(Form17ShortWeb.builder()
                .formId("1")
                .formType("2")
                .formDate("2018-08-05")
                .build());
        forms.add(Form17ShortWeb.builder()
                .formId("2")
                .formType("1")
                .formDate("2018-09-07")
                .build());

        return FormSeventeenListWeb.builder()
                .forms(forms)
                .build();
    }

    @GetMapping(value = "/forms")
    public FormSeventeenFullWeb getForm17ById(@AuthenticationPrincipal PsUser user,
                                              @RequestParam(value = "id") Long id) {

        HcUserSession hcUserSession = hcUserSessionService.findByPsUser(user);

        if (hcUserSession == null) {
            throw new HcAuthenticationException();
        }

        HcFormSeventeenService formSeventeenService = beanResolver.resolve(HcFormSeventeenService.class, hcUserSession.getHcType());
        formSeventeenService.getFormSeventeenById(hcUserSession, id);

        return FormSeventeenFullWeb.builder()
                .formId("1")
                .formType("2")
                .formDate("2018-08-05")
                .issueDate("2018-08-13")
                .content(getImage())
                .build();
    }

    @PostMapping(value = "/form/order")
    public void requestFormSeventeen(@AuthenticationPrincipal PsUser user,
                                     @RequestBody @Valid FormSeventeenRequest formSeventeenRequest,
                                     BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InputValidationException(bindingResult);
        }
    }

    private String getImage() {
        return "data:image/png;base64,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";
    }
}

