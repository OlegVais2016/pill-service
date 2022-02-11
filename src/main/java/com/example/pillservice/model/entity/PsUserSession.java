package com.example.pillservice.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "PS_USER_SESSION")
public class  PsUserSession extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private PsUser user;

    @Column(name = "PS_SESSION_ID", nullable = false, unique = true)
    private String sessionId;

    @Column(name = "IS_VALID")
    private boolean isValid;
    
}
