package com.example.pillservice.model.web.order;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderHistoryResponse {

    private Integer orderNumber;
    private List<HistoryRecipeResponse> recipes;
    private List<PillHistoryResponse> pills;

}
