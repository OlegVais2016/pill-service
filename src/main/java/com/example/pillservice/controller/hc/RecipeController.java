package com.example.pillservice.controller.hc;

import com.ps.core.model.entity.PsUser;
import com.ps.core.model.web.recipe.DoctorResponse;
import com.ps.core.model.web.recipe.ListRecipeResponse;
import com.ps.core.model.web.recipe.MedicineResponse;
import com.ps.core.model.web.recipe.RecipeResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/en/users")
public class RecipeController {

    @GetMapping("/recipes/{recipeId}")
    public RecipeResponse getRecipeById
            (@AuthenticationPrincipal PsUser user,
            @PathVariable ("recipeId") Integer id){

        List<MedicineResponse> medicineResponses = new ArrayList<>();
        medicineResponses.add(MedicineResponse.builder()
                .medicineName("Acamol")
                .dozePerDay(15)
                .doctorDescription("1 pill twice a day")
                .build());

        return RecipeResponse.builder()
                .recipeNumber("U123")
                .statementDate(LocalDate.parse("2018-10-03"))
                .expiryDate(LocalDate.parse("2018-10-23"))
                .isActive(true)
                .doctorInfo(DoctorResponse.builder()
                        .firstName("Gregory")
                        .lastName("House")
                        .licenseId("12345")
                        .medicalStatus(1)
                        .address("Rotshild 11, Tel-Aviv")
                        .phoneNumber("0530000000")
                        .build())
                .medicines(medicineResponses)
                .build();
    }



    @GetMapping("/recipes")
    public ListRecipeResponse getRecipes
            (@AuthenticationPrincipal PsUser user){

        List<MedicineResponse> medicineResponses = new ArrayList<>();
        medicineResponses.add(MedicineResponse.builder()
                .medicineName("Acamol")
                .dozePerDay(15)
                .doctorDescription("1 pill twice a day")
                .build());

        List<RecipeResponse> responseList = new ArrayList<>();
        responseList.add(RecipeResponse.builder()
                .recipeNumber("U123")
                .statementDate(LocalDate.parse("2018-10-03"))
                .expiryDate(LocalDate.parse("2018-10-23"))
                .isActive(true)
                .doctorInfo(DoctorResponse.builder()
                        .firstName("Gregory")
                        .lastName("House")
                        .licenseId("12345")
                        .medicalStatus(1)
                        .address("Rotshild 11, Tel-Aviv")
                        .phoneNumber("0530000000")
                        .build())
                .medicines(medicineResponses)
                .build());

        return ListRecipeResponse.builder()
                .recipes(responseList)
                .build();

    }
}
