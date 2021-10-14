package com.br.cooapi.combustivel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CombustivelDto {

    private int idCombusttivel;
    private String combustivel;

    public static CombustivelDto from (Combustivel combustivel) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(combustivel, CombustivelDto.class);
    }
}
