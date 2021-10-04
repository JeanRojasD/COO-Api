package com.br.cooapi.model;

import com.br.cooapi.brand.Brand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModelForm {

    private String modelo;
    private Brand brand;

}
