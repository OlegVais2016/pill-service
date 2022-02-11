package com.example.pillservice.service.impl;

import com.ps.core.exception.AuthenticationException;
import com.ps.core.model.entity.PsUser;
import com.ps.core.model.entity.PsUserSession;
import com.ps.core.model.web.login.UserInfoWeb;
import com.ps.core.model.web.login.UserLoginWebRequest;
import com.ps.core.model.web.login.UserLoginWebResponse;
import com.ps.core.repository.PsUserRepository;
import com.ps.core.repository.PsUserSessionRepository;
import com.ps.core.service.LoginService;
import com.ps.core.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class LoginServiceImpl implements LoginService {

    private PsUserRepository userRepository;
    private PsUserSessionRepository userSessionRepository;
    private UserCredentialsService credentialsService;


    @Autowired
    LoginServiceImpl(PsUserRepository userRepository,
                     PsUserSessionRepository userSessionRepository,
                     UserCredentialsService credentialsService) {
        this.userRepository = userRepository;
        this.userSessionRepository = userSessionRepository;
        this.credentialsService = credentialsService;
    }

    @Override
    @Transactional
    public UserLoginWebResponse login(UserLoginWebRequest loginRequest) {

        PsUser user = userRepository.findByEmail(loginRequest.getEmail());

        if (user == null || !checkPassword(user, loginRequest.getPassword())) {
            throw new AuthenticationException();
        }

        String sessionId = UUID.randomUUID().toString();
        userSessionRepository.save(PsUserSession.builder()
                .user(user)
                .sessionId(sessionId)
                .isValid(true)
                .build());

        return UserLoginWebResponse.builder()
                .token(sessionId)
                .userInfo(UserInfoWeb.builder()
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .build())
                .build();
    }

    @Override
    public void logout(String sessionId) {
        PsUserSession psUserSession = userSessionRepository.findBySessionId(sessionId);
        if (psUserSession != null) {
            psUserSession.setValid(false);
            userSessionRepository.save(psUserSession);
        }
    }

    @Override
    public void changePassword(PsUser user, String oldPassword, String newPassword) {

        credentialsService.updatePassword(user, oldPassword, newPassword);
    }

    private boolean checkPassword(PsUser user, String password) {

        return credentialsService.isPassword(user, password);
    }

}
