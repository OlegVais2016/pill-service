package com.example.pillservice.model.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PS_USER")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PsUser extends BaseEntity {

    @Column(name = "EMAIL", unique = true, length = 50, nullable = false)
    private String email;

    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;

}
