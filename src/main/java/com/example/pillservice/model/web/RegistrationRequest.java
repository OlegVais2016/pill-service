package com.example.pillservice.model.web;

import com.ps.core.validators.validPassword.ValidPassword;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegistrationRequest {

    @NotBlank
    @Email
    @Length(min = 3, max = 50)
    private String email;

    @NotBlank
    @ValidPassword(upperCaseLetters = true, lowerCaseLetters = true,specialCharacters = true,numbers = true)
    @Length(min = 8, max = 25)
    private String password;

    @NotBlank
    @Length(min = 3, max = 20)
    private String firstName;

    @NotBlank
    @Length(min = 3, max = 20)
    private String lastName;

}
