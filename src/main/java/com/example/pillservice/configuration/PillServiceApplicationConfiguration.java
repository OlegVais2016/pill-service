package com.example.pillservice.configuration;

import com.ps.core.exception.AuthenticationException;
import com.ps.core.exception.HcAuthenticationException;
import com.ps.core.exception.HcCommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Configuration
public class PillServiceApplicationConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .errorHandler(responseErrorHandler())
                .build();
    }

    @Bean
    public ResponseErrorHandler responseErrorHandler() {
        return new RestTemplateErrorHandler();
    }
}


@Slf4j
class RestTemplateErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().isError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode() == HttpStatus.UNAUTHORIZED) {
            throw new AuthenticationException();
        }

        if (response.getStatusCode() == HttpStatus.FORBIDDEN) {
            throw new HcAuthenticationException();
        }

        log.error("Error from HC [code]: " + response.getStatusCode().toString());
        log.error("Error from HC [body]: " + response.getBody().toString());
        log.error("Error from HC [headers]: " + response.getHeaders().toString());
        throw new HcCommonException();
    }
}