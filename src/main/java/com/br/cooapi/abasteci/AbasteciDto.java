package com.br.cooapi.abasteci;

import com.br.cooapi.combustivel.Combustivel;
import com.br.cooapi.combustivel.CombustivelDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbasteciDto {

    private Long idAbastecimento;
    private Double vlPago;
    private LocalDateTime dataTime = LocalDateTime.now();

    private CombustivelDto combustivel;

    public static AbasteciDto from (Abasteci abasteci) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(abasteci, AbasteciDto.class);
    }

}
