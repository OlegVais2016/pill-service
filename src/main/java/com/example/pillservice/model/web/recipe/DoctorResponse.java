package com.example.pillservice.model.web.recipe;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DoctorResponse {

    private String firstName;
    private String lastName;
    private String licenseId;
    private Integer medicalStatus;
    private String address;
    private String phoneNumber;
}
