package com.example.pillservice.model.web.account;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetAccountResponse {

    private String email;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private AccountAddressWeb address;
    private String phone;
}
