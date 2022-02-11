package com.example.pillservice.model.entity.converters;

import com.ps.core.model.entity.type.PsUserAccountStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PsUserAccountStatusConverter implements AttributeConverter<PsUserAccountStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(PsUserAccountStatus psUserAccountStatus) {
        return psUserAccountStatus == null ? null : psUserAccountStatus.getId();
    }

    @Override
    public PsUserAccountStatus convertToEntityAttribute(Integer integer) {
        return integer == null ? null : PsUserAccountStatus.getById(integer);
    }
}
