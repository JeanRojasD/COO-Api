package com.br.cooapi.brand;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Data
public class BrandDTO {

    private Long id;
    private String marca;

    public static BrandDTO from (Brand brand){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(brand, BrandDTO.class);
    }
}
