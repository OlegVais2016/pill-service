package com.example.pillservice.model.web.order;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ListOrderHistoryResponse {

    private List<OrderHistoryResponse> orders;
}
