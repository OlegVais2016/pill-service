package com.example.pillservice.model.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "PS_USER_CREDENTIAL")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PsUserCredential extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "USER_ID", nullable = false, unique = true)
    private PsUser user;

    @Column(name = "PASSWORD_HASH")
    private String passwordHash;

    @Column(name = "PASSWORD_SALT")
    private String passwordSalt;
}
