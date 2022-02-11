package com.example.pillservice.model.web.login.leumit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class LoginLeumitRequest {

    private String nationalId;
    private String password;
}
