package com.example.pillservice.model.web.order;

import com.ps.core.validators.validPhone.ValidPhone;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

class DeliveryAddressRequest {

    @Length(min = 3, max = 20,
            message = "City length should be between 3 and 20 characters")
    @NotBlank(message = "City cannot be blank")
    private String city;

    @Length(min = 3, max = 20,
            message = "Street length should be between 3 and 20 characters")
    @NotBlank(message = "Street cannot be blank")
    private String street;


    @Length(min = 1, max = 4,
            message = "House length should be between 1 and 4 characters")
    @NotBlank(message = "House cannot be blank")
    private String house;

    private String floor;

    @Length(min = 1, max = 4,
            message = "Apartment length should be between 1 and 4 characters")
    private String apartment;

    @NotBlank
    @ValidPhone
    private String phone;

}
