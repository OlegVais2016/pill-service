package com.example.pillservice.service.impl;


import com.ps.core.configuration.AppConfig;
import com.ps.core.exception.ConfirmationLinkException;
import com.ps.core.exception.EmailDuplicationException;
import com.ps.core.model.entity.*;
import com.ps.core.model.entity.type.PsUserAccountStatus;
import com.ps.core.model.web.RegistrationRequest;
import com.ps.core.repository.PsUserAccountConfigurationRepository;
import com.ps.core.repository.PsUserRepository;
import com.ps.core.repository.RegistrationConfirmationRepository;
import com.ps.core.service.RegistrationService;
import com.ps.core.service.SendEmailService;
import com.ps.core.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private PsUserRepository psUserRepository;

    @Autowired
    private UserCredentialsService userCredentialsService;

    @Autowired
    private RegistrationConfirmationRepository registrationConfirmationRepository;

    @Autowired
    private SendEmailService sendEmailService;

    @Autowired
    private PsUserAccountConfigurationRepository configurationRepository;

    @Autowired
    private AppConfig appConfig;


    @Override
    @Transactional
    public void registrationUser(RegistrationRequest request) {

        PsUser psUser = psUserRepository.findByEmail(request.getEmail());

        if(psUser != null){
            throw new EmailDuplicationException();
        }

        psUser = PsUser.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();

        psUserRepository.save(psUser);

        userCredentialsService.createAndSavePassword(psUser, request.getPassword());

        RegistrationConfirmation registrationConfirmation = RegistrationConfirmation.builder()
                .sendStatus(false)
                .confirmationLink(UUID.randomUUID().toString())
                .psUser(psUser)
                .isConfirmed(false)
                .build();

        registrationConfirmationRepository.save(registrationConfirmation);

        String url =  appConfig.getRegistrationConformationUrl() + registrationConfirmation.getConfirmationLink();
        sendEmailService.sendMail(psUser.getEmail(), "Registration confirmation", url, registrationConfirmation.getConfirmationLink());

        PsUserAccountConfiguration userConfiguration = PsUserAccountConfiguration.builder()
                .psUserAccountStatus(PsUserAccountStatus.CREATED)
                .psUser(psUser)
                .build();

        configurationRepository.save(userConfiguration);

    }


    @Override
    @Transactional
    public void registrationConfirmation(String link) {
        RegistrationConfirmation registrationConfirmation = registrationConfirmationRepository.findByConfirmationLink(link);
        if (registrationConfirmation == null) {
            throw new ConfirmationLinkException();
        }
        registrationConfirmation.setIsConfirmed(true);

        PsUserAccountConfiguration userConfiguration = configurationRepository.findByPsUser(registrationConfirmation.getPsUser());
        userConfiguration.setPsUserAccountStatus(PsUserAccountStatus.CONFIRMED);
    }

    @Transactional
    public void setSendStatus(String link){
        RegistrationConfirmation registrationConfirmation = registrationConfirmationRepository.findByConfirmationLink(link);
        registrationConfirmation.setSendStatus(true);
    }

}
