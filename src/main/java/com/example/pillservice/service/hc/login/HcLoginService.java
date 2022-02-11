package com.example.pillservice.service.hc.login;

import com.ps.core.model.entity.PsUser;
import com.ps.core.model.web.login.HcLoginResponse;

public interface HcLoginService {

    HcLoginResponse login(Object loginObject, PsUser psUser);
}
