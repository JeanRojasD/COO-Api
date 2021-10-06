package com.br.cooapi.typeservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;


@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class TypeServiceDTO {

    private Long id;
    private String nome;

    public TypeServiceDTO(String nome) {
    }

    public static TypeServiceDTO from(TypeService typeService){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(typeService, TypeServiceDTO.class);
    }
}
