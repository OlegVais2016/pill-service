package com.example.pillservice.model.web.order;

import com.ps.core.validators.letter.ValidLetters;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

class CustomerRequest {

    @Valid
    private DeliveryAddressRequest deliveryAddress;

    @Length(min = 3, max = 20, message = "First name length should be between 3 and 20 characters")
    @NotBlank(message = "First name cannot be blank")
    @ValidLetters
    private String firstName;

    @Length(min = 3, max = 20, message = "Last name length should be between 3 and 20 characters")
    @NotBlank(message = "Last name cannot be blank")
    @ValidLetters
    private String lastName;



}
