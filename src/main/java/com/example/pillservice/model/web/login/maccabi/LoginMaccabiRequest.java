package com.example.pillservice.model.web.login.maccabi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginMaccabiRequest {
    private String nationalId;
    private String password;
    private String foreignCitizenId;
}
