package com.example.pillservice.model.web.login;


import com.ps.core.validators.validPassword.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserLoginWebRequest {

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    @ValidPassword(upperCaseLetters = true, lowerCaseLetters = true, numbers = true)
    private String password;

}
