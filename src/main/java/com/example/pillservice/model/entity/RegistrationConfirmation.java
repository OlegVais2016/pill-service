package com.example.pillservice.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "REGISTRATION_CONFIRMATION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class RegistrationConfirmation extends BaseEntity{

    @Column(name = "SEND_STATUS")
    private Boolean sendStatus;

    @Column(name = "CONFIRMATION_LINK", length = 50, unique = true, nullable = false)
    private String confirmationLink;

    @OneToOne
    @JoinColumn(name = "PS_USER_ID")
    private PsUser psUser;

    @Column(name = "IS_CONFIRMED")
    private Boolean isConfirmed;
}