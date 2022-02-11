package com.example.pillservice.service.hc.form;

import com.ps.core.model.entity.HcUserSession;
import com.ps.core.model.entity.PsUser;
import com.ps.core.model.web.form17.FormSeventeenFullWeb;
import com.ps.core.model.web.form17.FormSeventeenListWeb;
import com.ps.core.model.web.form17.FormSeventeenRequest;

public interface HcFormSeventeenService {

    FormSeventeenFullWeb getFormSeventeenById(
            HcUserSession userSession,
            Long id
    );
    void requestFormSeventeen(
            HcUserSession userSession,
            PsUser user,
            FormSeventeenRequest formSeventeenRequest);
    FormSeventeenListWeb getFormSeventeenList(
            HcUserSession hcUserSession,
            PsUser user,
            Integer page,
            Integer size);

}
