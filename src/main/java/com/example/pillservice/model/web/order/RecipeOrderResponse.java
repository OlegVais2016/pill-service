package com.example.pillservice.model.web.order;


import com.ps.core.model.web.recipe.DoctorResponse;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RecipeOrderResponse {

    private String recipeNumber;
    private LocalDate statementDate;
    private LocalDate expiryDate;
    private DoctorResponse doctorInfo;
}
