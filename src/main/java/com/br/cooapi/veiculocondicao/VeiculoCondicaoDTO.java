package com.br.cooapi.veiculocondicao;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Data
public class VeiculoCondicaoDTO {

    private Long id;
    private String condicao;

    public static VeiculoCondicaoDTO from (VeiculoCondicao veiculoCondicao){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(veiculoCondicao, VeiculoCondicaoDTO.class);
    }
}
