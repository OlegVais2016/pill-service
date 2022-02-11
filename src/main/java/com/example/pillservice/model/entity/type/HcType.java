package com.example.pillservice.model.entity.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum HcType {

    MACCABI(1, "maccabi"),
    CLALIT(2, "clalit"),
    MEUHEDET(3, "meuhedet"),
    LEUMIT(4, "leumit"),
    DEMO(5, "demo")
    ;

    private Integer id;
    private String systemName;

    public static HcType findByExactName(String name) {
        if (name == null) {
            return null;
        }

        return Arrays.stream(values())
                .filter(x -> name.equalsIgnoreCase(x.getSystemName()))
                .findFirst()
                .orElse(null);
    }


    public static HcType findByStartsWithName(String name) {
        if (name == null) {
            return null;
        }

        return Arrays.stream(values())
                .filter(x -> name.startsWith(x.getSystemName()))
                .findFirst()
                .orElse(null);

    }

    public static HcType findById(Integer id) {
        if (id == null) {
            return null;
        }

        return Arrays.stream(values())
                .filter(x -> id.equals(x.getId()))
                .findFirst()
                .orElse(null);
    }

}
