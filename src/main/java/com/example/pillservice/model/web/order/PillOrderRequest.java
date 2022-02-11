package com.example.pillservice.model.web.order;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
class PillOrderRequest {

    private Integer id;
    private Integer quantity;
}
