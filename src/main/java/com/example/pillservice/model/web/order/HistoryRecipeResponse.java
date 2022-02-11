package com.example.pillservice.model.web.order;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class HistoryRecipeResponse {

    private Integer recipeNumber;
    private LocalDate statementDate;
    private String doctor;
}
