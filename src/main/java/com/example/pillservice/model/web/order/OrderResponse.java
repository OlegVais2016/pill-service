package com.example.pillservice.model.web.order;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderResponse {

    private Integer orderNumber;
    private CustomerResponse customer;
    private RecipeOrderResponse recipe;
    private List<PillOrderResponse> pills;
    private Double total;
}
