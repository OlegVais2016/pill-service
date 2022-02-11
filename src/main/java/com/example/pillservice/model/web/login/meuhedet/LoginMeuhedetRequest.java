package com.example.pillservice.model.web.login.meuhedet;

import com.ps.core.validators.dateOfBirth.ValidDateOfBirth;
import com.ps.core.validators.nationalID.NationalIdChecksum;
import com.ps.core.validators.nationalID.NationalIdFormat;
import com.ps.core.validators.validPassword.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginMeuhedetRequest {

    @NotNull
    @NotBlank
    @NationalIdFormat
    @NationalIdChecksum
    private String nationalId;

    @NotNull
    @NotBlank(message = "Password cannot be blank")
    @Length(min = 8, max = 50, message = "Password length should be between 8 and 50 characters")
    @ValidPassword(upperCaseLetters = true,
            lowerCaseLetters = true,
            specialCharacters = true,
            numbers = true,
            message = "Password must contain uppercase, lowercase letters, numbers and symbols")
    private String password;

    @NotBlank
    @ValidDateOfBirth
    private String dateOfBirth;
}

