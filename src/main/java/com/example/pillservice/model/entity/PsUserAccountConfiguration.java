package com.example.pillservice.model.entity;

import com.ps.core.model.entity.converters.PsUserAccountStatusConverter;
import com.ps.core.model.entity.type.PsUserAccountStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "PS_USER_ACCOUNT_CONFIGURATION")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PsUserAccountConfiguration extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "PS_USER_ID", nullable = false, unique = true)
    private PsUser psUser;

    @Column(name = "USER_ACCOUNT_STATUS_ID")
    @Convert(converter = PsUserAccountStatusConverter.class)
    private PsUserAccountStatus psUserAccountStatus;
}
