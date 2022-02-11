package com.example.pillservice.service;

import com.ps.core.model.entity.PsUser;

public interface UserCredentialsService {

    void createAndSavePassword(PsUser user, String password);
    boolean isPassword(PsUser user, String password);
    void updatePassword(PsUser user, String oldPassword, String newPassword);
}
