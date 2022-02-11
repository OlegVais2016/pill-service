package com.example.pillservice.model.web.recipe;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ListRecipeResponse {

    private List<RecipeResponse> recipes;

}
