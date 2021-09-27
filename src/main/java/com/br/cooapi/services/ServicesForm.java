package com.br.cooapi.services;

import com.br.cooapi.store.StoreDTO;
import com.br.cooapi.typeservice.TypeServiceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ServicesForm {

    private Double valorPago;
    private LocalDateTime data;
    private TypeServiceDTO tpRecebeServico;
    private StoreDTO loja;
}
