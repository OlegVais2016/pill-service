package com.example.pillservice.model.web.drugs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PillsListWeb {

    private List<PillWeb> drugs;
}
