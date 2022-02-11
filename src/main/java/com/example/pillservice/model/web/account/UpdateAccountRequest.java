package com.example.pillservice.model.web.account;



import com.ps.core.model.entity.type.PsUserAccountStatus;
import com.ps.core.validators.dateOfBirth.ValidDateOfBirth;
import com.ps.core.validators.letter.ValidLetters;
import com.ps.core.validators.validPhone.ValidPhone;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;




@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UpdateAccountRequest {

    @Length(min = 3, max = 20,
            message = "First name length should be between 3 and 20 characters")
    @NotBlank(message = "First name cannot be blank")
    @ValidLetters
            (message = "First name must contains only english alphabet symbols")
    private String firstName;

    @Length(min = 3, max = 20,
            message = "Last name length should be between 3 and 20 characters")
    @NotBlank(message = "Last name cannot be blank")
    @ValidLetters
            (message = "Last name must contains only english alphabet symbols")
    private String lastName;

    private PsUserAccountStatus psUserAccountStatus;

    @NotBlank(message = "Date of birth cannot be blank")
    @ValidDateOfBirth
    private String dateOfBirth;

    @Valid
    private AccountAddressWeb address;

    @NotBlank
    @ValidPhone
    private String phone;
}
