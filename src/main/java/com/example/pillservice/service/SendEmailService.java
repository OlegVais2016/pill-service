package com.example.pillservice.service;


public interface SendEmailService {

    void sendMail(String sentTo, String subject, String text, String link);
}
