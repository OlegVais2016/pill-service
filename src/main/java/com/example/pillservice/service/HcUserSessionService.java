package com.example.pillservice.service;

import com.ps.core.model.entity.HcUserSession;
import com.ps.core.model.entity.PsUser;
import com.ps.core.model.entity.type.HcType;

public interface HcUserSessionService {

    HcUserSession findByPsUser(PsUser user);
    HcUserSession saveOrUpdate(PsUser user, String sessionId, HcType hcType);
    HcUserSession saveOrUpdate(HcUserSession userSession);

    void delete(PsUser user);
}
