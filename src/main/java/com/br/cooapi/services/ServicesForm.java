package com.br.cooapi.services;

import com.br.cooapi.store.StoreDTO;
import com.br.cooapi.typeservice.TypeServiceDTO;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class ServicesForm {

    private Double valorPago;
    private LocalDateTime data;
    private TypeServiceDTO tpRecebeServico;
    private StoreDTO loja;

    public ServicesForm(Double valorPago, LocalDateTime data, TypeServiceDTO tpRecebeServico, StoreDTO loja) {
    }
}
