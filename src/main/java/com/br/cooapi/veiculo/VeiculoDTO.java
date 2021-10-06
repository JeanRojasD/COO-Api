package com.br.cooapi.veiculo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDTO {

    @Id
    @GeneratedValue
    private Long idveiculo;
    private String placa;
    private Integer ano;

    public static  VeiculoDTO from(Veiculo veiculo){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return  modelMapper.map(veiculo, VeiculoDTO.class);
    }
}
