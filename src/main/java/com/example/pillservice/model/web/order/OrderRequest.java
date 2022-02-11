package com.example.pillservice.model.web.order;


import lombok.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class OrderRequest {


    @Valid
    private CustomerRequest customerRequest;
    private List<PillOrderRequest> pills;

}
