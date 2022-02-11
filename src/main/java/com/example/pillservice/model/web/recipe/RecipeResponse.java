package com.example.pillservice.model.web.recipe;

import lombok.*;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RecipeResponse {

    private String recipeNumber;
    private LocalDate statementDate;
    private LocalDate expiryDate;
    private Boolean isActive;
    private DoctorResponse doctorInfo;
    private List<MedicineResponse> medicines;

}
