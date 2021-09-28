package com.br.cooapi.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO {

    private Long id;
    private String nome;
    private String endereco;


    public static StoreDTO from(Store store){
       ModelMapper modelMapper = new ModelMapper();
       modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
       return modelMapper.map(store, StoreDTO.class);
    }
}
