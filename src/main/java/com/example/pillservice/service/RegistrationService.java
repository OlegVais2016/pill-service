package com.example.pillservice.service;

import com.ps.core.model.web.RegistrationRequest;

public interface RegistrationService {

    void registrationUser (RegistrationRequest request) ;
    void registrationConfirmation(String link);
    void setSendStatus(String link);
}
