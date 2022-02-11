package com.example.pillservice.model.entity.converters;

import com.ps.core.model.entity.type.HcType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class HcTypeConverter implements AttributeConverter<HcType, Integer> {


    @Override
    public Integer convertToDatabaseColumn(HcType attribute) {
        return attribute == null ? null : attribute.getId();
    }

    @Override
    public HcType convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : HcType.findById(dbData);
    }
}
