package com.example.pillservice.model.web.account;

import com.ps.core.model.entity.PsUserInfo;
import com.ps.core.model.entity.type.PsUserAccountStatus;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UpdateAccountResponse {

    private String firstName;
    private String lastName;
    private PsUserAccountStatus psUserAccountStatus;
    private LocalDate dateOfBirth;
    private AccountAddressWeb address;
    private String phone;

    public  UpdateAccountResponse(PsUserInfo psUserInfo) {
        this.firstName = psUserInfo.getPsUser().getFirstName();
        this.lastName = psUserInfo.getPsUser().getLastName();
        this.psUserAccountStatus = getPsUserAccountStatus();
        this.dateOfBirth = psUserInfo.getDateOfBirth();
        this.address = AccountAddressWeb.builder()
                .city(psUserInfo.getCity())
                .street(psUserInfo.getStreet())
                .house(psUserInfo.getHouseNumber())
                .apartment(psUserInfo.getApartment())
                .entrance(psUserInfo.getEntrance())
                .build();
        this.phone = psUserInfo.getPhoneNumber();
    }
}
