package com.example.pillservice.model.web.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class HcLoginResponse {

    private String firstName;
    private String lastName;
}
