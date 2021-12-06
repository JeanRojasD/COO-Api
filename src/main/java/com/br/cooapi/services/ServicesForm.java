package com.br.cooapi.services;

import com.br.cooapi.store.StoreDTO;
import com.br.cooapi.typeservice.TypeServiceDTO;
import com.br.cooapi.veiculo.VeiculoDTO;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServicesForm {

    private Double valorPago;
    private LocalDate data;
    private VeiculoDTO veiculo;
    private TypeServiceDTO tpRecebeServico;
    private StoreDTO loja;

}

