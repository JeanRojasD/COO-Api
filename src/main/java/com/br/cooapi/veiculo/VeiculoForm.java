package com.br.cooapi.veiculo;

import com.br.cooapi.model.Model;
import com.br.cooapi.model.ModelDTO;
import com.br.cooapi.services.Services;
import com.br.cooapi.services.ServicesDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VeiculoForm {

    private String placa;
    private Integer ano;

    private ServicesDTO services;
    private ModelDTO model;

    public VeiculoForm(String placa, Integer ano) {
        this.placa = placa;
        this.ano = ano;
    }
}
