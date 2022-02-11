package com.example.pillservice.model.web.order;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponse {

    private String firstName;
    private String lastName;
    private AddressResponse addressResponse;

}
