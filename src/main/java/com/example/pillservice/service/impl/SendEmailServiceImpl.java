package com.example.pillservice.service.impl;

import com.ps.core.service.RegistrationService;
import com.ps.core.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SendEmailServiceImpl implements SendEmailService{

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private RegistrationService registrationService;

    @Override
    @Async
    public void sendMail(String sentTo, String subject, String text, String link) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(sentTo);
        mail.setSubject(subject);
        mail.setText(text);

        try {
            javaMailSender.send(mail);
        } catch (MailException e) {
            e.printStackTrace();
        }

        registrationService.setSendStatus(link);
    }
}
