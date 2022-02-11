package com.example.pillservice.service.hc.login.impl;

import com.ps.core.exception.AuthenticationException;
import com.ps.core.model.entity.PsUser;
import com.ps.core.model.entity.type.HcType;
import com.ps.core.model.external.HcExternalLoginResponse;
import com.ps.core.model.web.login.HcLoginResponse;
import com.ps.core.service.HcUserSessionService;
import com.ps.core.service.hc.login.HcLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service("demoHcLoginService")
@Transactional
public class HcDemoLoginServiceImpl implements HcLoginService {

    private static final String LOGIN_PATH = "/hc/demo/login";

    @Value("${ps.demo.base-url}")
    private String url;


    @Autowired
    private HcUserSessionService hcUserSessionService;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public HcLoginResponse login(Object loginObject, PsUser user) {

        ResponseEntity<HcExternalLoginResponse> responseEntity = restTemplate.exchange(
                url + LOGIN_PATH,
                HttpMethod.POST,
                new HttpEntity<>(loginObject), HcExternalLoginResponse.class
        );

        if (responseEntity.getBody() == null) {
            throw new AuthenticationException();
        }

        HcExternalLoginResponse response = responseEntity.getBody();


        hcUserSessionService.saveOrUpdate(user, response.getToken(), HcType.DEMO);

        return HcLoginResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

}
