package com.example.pillservice.model.web.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserLoginWebResponse {

    private String token;
    private UserInfoWeb userInfo;

}
