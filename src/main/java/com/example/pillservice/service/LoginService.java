package com.example.pillservice.service;

import com.ps.core.model.entity.PsUser;
import com.ps.core.model.web.login.UserLoginWebRequest;
import com.ps.core.model.web.login.UserLoginWebResponse;

public interface LoginService {

    UserLoginWebResponse login(UserLoginWebRequest loginRequest);

    void logout(String sessionId);

    void changePassword(PsUser user, String oldPassword, String newPassword);

}
