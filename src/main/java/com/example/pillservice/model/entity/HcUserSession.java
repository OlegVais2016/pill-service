package com.example.pillservice.model.entity;

import com.ps.core.model.entity.converters.HcTypeConverter;
import com.ps.core.model.entity.type.HcType;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "HC_USER_SESSION")
public class HcUserSession extends BaseEntity {

    @Column(name = "SESSION_ID")
    private String sessionId;


    @JoinColumn(name = "USER_ID", unique = true)
    @OneToOne
    private PsUser user;


    @Column(name = "HC_TYPE_ID")
    @Convert(converter = HcTypeConverter.class)
    private HcType hcType;


}
