package com.example.pillservice.controller.hc;

import com.ps.core.exception.InputValidationException;
import com.ps.core.model.entity.PsUser;
import com.ps.core.model.web.order.*;
import com.ps.core.model.web.recipe.DoctorResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/en/users")
public class OrderMedicineController {

    @PostMapping("/order")
    public OrderResponse orderMedicine
            (@AuthenticationPrincipal PsUser user,
             @RequestBody @Valid OrderRequest orderRequest,
             BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            throw new InputValidationException(bindingResult);
        }

        List<PillOrderResponse> pillOrderResponseList = new ArrayList<>();
        pillOrderResponseList.add(PillOrderResponse.builder()
                .id(11)
                .title("TRAMADOL")
                .price(30.00)
                .quantityPerItem(2)
                .discount(22.00)
                .requiresRecipe(false)
                .build());

        return OrderResponse.builder()
                .orderNumber(1)
                .customer(CustomerResponse.builder()
                        .firstName("Alina")
                        .lastName("Khomenker")
                        .addressResponse(AddressResponse.builder()
                                .city("Lod")
                                .street("Plout")
                                .house("45")
                                .phone("0530000000")
                                .build())
                        .build())
                .recipe(RecipeOrderResponse.builder()
                        .recipeNumber("U123")
                        .statementDate(LocalDate.parse("2018-10-03"))
                        .expiryDate(LocalDate.parse("2018-10-23"))
                        .doctorInfo(DoctorResponse.builder()
                                .firstName("Gregory")
                                .lastName("House")
                                .licenseId("12345")
                                .medicalStatus(1)
                                .address("Rotshild 11, Tel-Aviv")
                                .phoneNumber("0530000000")
                                .build())
                        .build())
                .pills(pillOrderResponseList)
                .total(323.54)
                .build();
    }

    @GetMapping("/history")
    public ListOrderHistoryResponse getOrderHistory
            (@AuthenticationPrincipal PsUser user,
             @RequestParam  Integer page, @RequestParam Integer size){

        List<PillHistoryResponse> pillHistoryResponses =
                new ArrayList<>();
        pillHistoryResponses.add(PillHistoryResponse.builder()
                .id(11)
                .title("TRAMADOL")
                .build());

        List<HistoryRecipeResponse> historyRecipeResponses =
                new ArrayList<>();
        historyRecipeResponses.add(HistoryRecipeResponse.builder()
                .recipeNumber(1)
                .statementDate(LocalDate.parse("2018-10-03"))
                .doctor("Gregory House")
                .build());

        List<OrderHistoryResponse> responseList = new ArrayList<>();
        responseList.add(OrderHistoryResponse.builder()
                .orderNumber(1)
                .recipes(historyRecipeResponses)
                .pills(pillHistoryResponses)
                .build());

        return ListOrderHistoryResponse.builder()
                .orders(responseList)
                .build();
    }
}
