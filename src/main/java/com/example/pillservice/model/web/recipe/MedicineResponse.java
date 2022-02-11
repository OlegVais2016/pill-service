package com.example.pillservice.model.web.recipe;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MedicineResponse {

    private String medicineName;
    private Integer dozePerDay;
    private String doctorDescription;

}
