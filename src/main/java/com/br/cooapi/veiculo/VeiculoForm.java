package com.br.cooapi.veiculo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoForm {

    private String placa;
    private Integer ano;

}
