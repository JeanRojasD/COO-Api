package com.br.cooapi.services;


import com.br.cooapi.store.StoreDTO;
import com.br.cooapi.typeservice.TypeServiceDTO;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.time.LocalDateTime;

@Data
public class ServicesDTO {
    
    private Long id;
    private Double valorPago;
    private LocalDateTime data;
    private TypeServiceDTO tpRecebeServico;
    private StoreDTO loja;

    public static ServicesDTO from(Services services){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(services, ServicesDTO.class);
    }
}