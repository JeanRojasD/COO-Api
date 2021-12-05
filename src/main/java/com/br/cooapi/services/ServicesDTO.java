package com.br.cooapi.services;


import com.br.cooapi.store.StoreDTO;
import com.br.cooapi.typeservice.TypeServiceDTO;
import com.br.cooapi.veiculo.VeiculoDTO;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServicesDTO {
    
    private Long id;
    private Double valorPago;
    private LocalDateTime data;
    private VeiculoDTO veiculo;
    private TypeServiceDTO tpRecebeServico;
    private StoreDTO loja;

    public static ServicesDTO from(Services services){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(services, ServicesDTO.class);
    }
}