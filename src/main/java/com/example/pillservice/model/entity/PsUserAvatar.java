package com.example.pillservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PS_USER_AVATAR")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PsUserAvatar extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "USER_ID", nullable = false, unique = true)
    private PsUser user;

    @Lob
    @Column(name = "AVATAR", columnDefinition="BLOB")
    private byte[] image;
}
