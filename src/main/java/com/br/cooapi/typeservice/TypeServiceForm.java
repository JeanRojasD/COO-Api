package com.br.cooapi.typeservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
@AllArgsConstructor
public class TypeServiceForm {

    private Long id;
    @NotNull @NotBlank
    private String nome;
}
