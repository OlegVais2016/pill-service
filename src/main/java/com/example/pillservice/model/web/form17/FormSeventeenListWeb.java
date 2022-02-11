package com.example.pillservice.model.web.form17;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FormSeventeenListWeb {

    private List<Form17ShortWeb> forms;
}