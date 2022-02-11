package com.example.pillservice.service.system;

import com.ps.core.model.entity.type.HcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class HcBeanResolver {

    @Autowired
    private ApplicationContext applicationContext;

    public <T> T resolve(Class<T> interfaceType, HcType healthCaretType) {
        return applicationContext.getBeansOfType(interfaceType)
                .entrySet()
                .stream()
                .filter(x -> x.getKey().startsWith(healthCaretType.getSystemName()))
                .findFirst()
                .orElseThrow(() -> {
                    String errorMessage = String.format("No bean found for type [%s] and health care type [%s]",
                            interfaceType.getName(), healthCaretType.getSystemName());
                    return new IllegalArgumentException(errorMessage);
                })
                .getValue();
    }
}
