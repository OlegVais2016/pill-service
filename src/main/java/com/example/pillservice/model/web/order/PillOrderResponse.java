package com.example.pillservice.model.web.order;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PillOrderResponse {

    private Integer id;
    private String title;
    private Double price;
    private Integer quantityPerItem;
    private Double discount;
    private Boolean requiresRecipe;

}
