package com.example.pillservice.model.entity.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter

public enum PsUserAccountStatus {
    CREATED(1),
    CONFIRMED(2);

    private Integer id;

    public static PsUserAccountStatus getById(Integer id) {
        return Arrays.stream(values())
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(PsUserAccountStatus.CREATED);
    }
}
