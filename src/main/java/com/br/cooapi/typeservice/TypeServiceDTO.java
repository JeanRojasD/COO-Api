package com.br.cooapi.typeservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class TypeServiceDTO {

    private Long id;
    @NotNull @NotBlank
    private String nome;

    public static TypeServiceDTO from(TypeService typeService){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(typeService, TypeServiceDTO.class);
    }
}
