package com.example.pillservice.model.web.account;

import com.ps.core.validators.letter.ValidLetters;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AccountAddressWeb {

    @Length(min = 3, max = 20,
            message = "City length should be between 3 and 20 characters")
    @NotBlank(message = "City cannot be blank")
    @ValidLetters
            (message = "City must contains only english alphabet symbols")
    private String city;

    @Length(min = 3, max = 20,
            message = "Street length should be between 3 and 20 characters")
    @NotBlank(message = "Street  cannot be blank")
    @ValidLetters
            (message = "Street must contains only english alphabet symbols")
    private String street;

    @Length(min = 1, max = 4,
            message = "House length should be between 1 and 4 characters")
    @NotBlank(message = "House cannot be blank")
    private String house;

    @Length(min = 1, max = 4,
            message = "Apartment length should be between 1 and 4 characters")
    private String apartment;

    @Length(min = 1, max = 1,
            message = "Entrance must contains only 1 character")
    private String entrance;
}
