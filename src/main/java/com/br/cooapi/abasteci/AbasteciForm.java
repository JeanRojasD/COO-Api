package com.br.cooapi.abasteci;

import com.br.cooapi.combustivel.Combustivel;
import com.br.cooapi.combustivel.CombustivelDto;
import com.br.cooapi.veiculo.VeiculoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbasteciForm {

    private Double vlLitro;
    private Double litros;
    private VeiculoDTO veiculos;
    private CombustivelDto combustivel;

}
