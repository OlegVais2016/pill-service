package com.example.pillservice.model.web;

import com.ps.core.validators.validPassword.ValidPassword;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChangePasswordRequest {

    private String currentPassword;

    @Length(min = 8, max = 25, message = "Password length should be between 8 and 25 characters")
    @NotBlank(message = "Password cannot be blank")
    @ValidPassword(upperCaseLetters = true,lowerCaseLetters = true,
            numbers = true,specialCharacters = true)
    private String newPassword;

}
