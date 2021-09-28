package com.br.cooapi.model;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Data
public class ModelDTO {

    private Long id;
    private String modelo;

    public static ModelDTO from (Model model){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(model, ModelDTO.class);
    }
}
