package com.example.pillservice.model.web.order;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddressResponse {

    private String city;
    private String street;
    private String house;
    private String phone;

}
