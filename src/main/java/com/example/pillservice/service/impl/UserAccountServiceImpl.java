package com.example.pillservice.service.impl;

import com.ps.core.exception.NotFoundException;
import com.ps.core.model.entity.PsUser;
import com.ps.core.model.entity.PsUserInfo;
import com.ps.core.model.web.account.AccountAddressWeb;
import com.ps.core.model.web.account.GetAccountResponse;
import com.ps.core.model.web.account.UpdateAccountRequest;
import com.ps.core.model.web.account.UpdateAccountResponse;
import com.ps.core.repository.PsUserAccountRepository;
import com.ps.core.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private PsUserAccountRepository psUserAccountRepository;

    @Autowired
    public UserAccountServiceImpl(PsUserAccountRepository psUserAccountRepository) {
        this.psUserAccountRepository = psUserAccountRepository;
    }

    @Override
    public UpdateAccountResponse updateAccount(UpdateAccountRequest updateAccountRequest, PsUser psUser) {

        String dateString = updateAccountRequest.getDateOfBirth();
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter
                .ofPattern("yyyy-MM-dd"));

        PsUserInfo psUserInfo = psUserAccountRepository.findByPsUser(psUser);
        if (psUserInfo == null){
            throw new NotFoundException("User account not found");
        }

        psUser.setFirstName(updateAccountRequest.getFirstName());
        psUser.setLastName(updateAccountRequest.getLastName());
        psUserInfo.setPsUser(psUser);
        psUserInfo.setDateOfBirth(date);
        psUserInfo.setCity(updateAccountRequest.getAddress().getCity());
        psUserInfo.setStreet(updateAccountRequest.getAddress().getStreet());
        psUserInfo.setHouseNumber(updateAccountRequest.getAddress().getHouse());
        psUserInfo.setApartment(updateAccountRequest.getAddress().getApartment());
        psUserInfo.setEntrance(updateAccountRequest.getAddress().getEntrance());
        psUserInfo.setPhoneNumber(updateAccountRequest.getPhone());

        return new UpdateAccountResponse(psUserAccountRepository.save(psUserInfo));

    }

    @Override
    public GetAccountResponse getAccount(PsUser psUser) {

        PsUserInfo psUserInfo =
                psUserAccountRepository.findByPsUser(psUser);
        if (psUserInfo == null){
            throw new NotFoundException("User account not found");
        }
        return GetAccountResponse.builder()
                .email(psUser.getEmail())
                .firstName(psUser.getFirstName())
                .lastName(psUser.getLastName())
                .dateOfBirth(psUserInfo.getDateOfBirth())
                .address(AccountAddressWeb.builder()
                        .city(psUserInfo.getCity())
                        .street(psUserInfo.getStreet())
                        .house(psUserInfo.getHouseNumber())
                        .apartment(psUserInfo.getApartment())
                        .entrance(psUserInfo.getEntrance())
                        .build())
                .phone(psUserInfo.getPhoneNumber())
                .build();
    }
}
