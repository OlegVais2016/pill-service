package com.example.pillservice.service.impl;

import com.ps.core.configuration.AppConfig;
import com.ps.core.model.entity.RegistrationConfirmation;
import com.ps.core.repository.RegistrationConfirmationRepository;
import com.ps.core.service.SchedulerService;
import com.ps.core.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulerServiceImpl implements SchedulerService {

    @Autowired
    private RegistrationConfirmationRepository registrationConfirmationRepository;

    @Autowired
    private SendEmailService sendEmailService;

    @Autowired
    private AppConfig appConfig;

    @Scheduled(fixedRate = 60000)
    public void checkEmail() {

        List<RegistrationConfirmation> unsentEmails = registrationConfirmationRepository.findBySendStatusFalse();

        for (int i=0; i<unsentEmails.size(); i++) {
            sendEmailService.sendMail(unsentEmails.get(i).getPsUser().getEmail(),
                    "Registration confirmation",
                    appConfig.getRegistrationConformationUrl()+unsentEmails.get(i).getConfirmationLink(),
                    unsentEmails.get(i).getConfirmationLink());
        }
    }
}
