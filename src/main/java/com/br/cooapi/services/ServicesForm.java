package com.br.cooapi.services;

import com.br.cooapi.store.StoreDTO;
import com.br.cooapi.typeservice.TypeServiceDTO;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServicesForm {

    private Double valorPago;
    private LocalDateTime data;
    private TypeServiceDTO tpRecebeServico;
    private StoreDTO loja;

}
