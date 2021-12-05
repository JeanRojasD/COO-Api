package com.br.cooapi.abasteci;

import com.br.cooapi.combustivel.Combustivel;
import com.br.cooapi.combustivel.CombustivelDto;
import com.br.cooapi.veiculo.Veiculo;
import com.br.cooapi.veiculo.VeiculoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbasteciDto {

    private Long id;
    private Double vlLitro;
    private Double litros;
    private LocalDate dataTime;
    private VeiculoDTO veiculos;
    private CombustivelDto combustivel;

    public static AbasteciDto from (Abasteci abasteci) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(abasteci, AbasteciDto.class);
    }

}
