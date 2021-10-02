package com.br.cooapi.model;

import com.br.cooapi.brand.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelForm {

    private String modelo;
    private Brand brand;

}
