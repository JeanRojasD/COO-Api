package com.br.cooapi.abasteci;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbasteciDto {

    private int idAbastecimento;
    private long vlPago;
    private LocalDateTime dataTime = LocalDateTime.now();

    public static AbasteciDto from (Abasteci abasteci) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(abasteci, AbasteciDto.class);
    }

}
