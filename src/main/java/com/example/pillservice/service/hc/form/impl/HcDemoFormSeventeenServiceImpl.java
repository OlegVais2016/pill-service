package com.example.pillservice.service.hc.form.impl;

import com.ps.core.model.entity.HcUserSession;
import com.ps.core.model.entity.PsUser;
import com.ps.core.model.web.form17.FormSeventeenFullWeb;
import com.ps.core.model.web.form17.FormSeventeenListWeb;
import com.ps.core.model.web.form17.FormSeventeenRequest;
import com.ps.core.service.hc.form.HcFormSeventeenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("demoFormSeventeenService")
public class HcDemoFormSeventeenServiceImpl implements HcFormSeventeenService {

    private static final String AUTH_HEADER = "Authorization";
    private static final String REQUEST_URI = "/hc/demo/forms";

    @Autowired
    private RestTemplate restTemplate;

    @Value("${ps.demo.base-url}")
    private String url;



    @Override
    public FormSeventeenFullWeb getFormSeventeenById(HcUserSession userSession, Long id) {
        String fullUrl = url + REQUEST_URI + "/" + id;

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(AUTH_HEADER, userSession.getSessionId());

        HttpEntity entity = new HttpEntity(httpHeaders);
        ResponseEntity<FormSeventeenFullWeb> responseEntity = restTemplate.exchange(

                fullUrl,
                HttpMethod.GET,
                entity,
                FormSeventeenFullWeb.class);

        return responseEntity.getBody();
    }

    @Override
    public void requestFormSeventeen(HcUserSession userSession,
                                     PsUser user,
                                     FormSeventeenRequest formSeventeenRequest) {

    }

    @Override
    public FormSeventeenListWeb getFormSeventeenList(HcUserSession userSession,
                                                     PsUser user,
                                                     Integer page,
                                                     Integer size) {
        return null;
    }
}
