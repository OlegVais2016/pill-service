package com.example.pillservice.model.web.drugs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DrugWeb {
    private String id;
    private String title;
    private String price;
    private String quantityPerItem;
    private String discount;
    private String requiresRecipe;
}
