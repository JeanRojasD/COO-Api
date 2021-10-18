package com.br.cooapi.abasteci;

import com.br.cooapi.combustivel.Combustivel;
import com.br.cooapi.combustivel.CombustivelDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbasteciForm {

    private Double vlPago;

    private CombustivelDto combustivel;

}
