package com.example.pillservice.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PS_USER_ACCOUNT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PsUserInfo extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "USER_ID", nullable = false, unique = true)
    private PsUser psUser;

    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;

    @Column(name = "APARTMENT")
    private String apartment;

    @Column(name = "ENTRANCE")
    private String entrance;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
}
