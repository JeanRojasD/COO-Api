package com.br.cooapi.veiculo;

import com.br.cooapi.abasteci.AbasteciDto;
import com.br.cooapi.model.Model;
import com.br.cooapi.model.ModelDTO;
import com.br.cooapi.services.Services;
import com.br.cooapi.services.ServicesDTO;
import com.br.cooapi.user.UserDTO;
import com.br.cooapi.veiculocondicao.VeiculoCondicaoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDTO {

    private Long id;
    private String placa;
    private Integer ano;

    private ServicesDTO services;
    private ModelDTO model;
    private UserDTO user;
    private AbasteciDto abasteci;
    private VeiculoCondicaoDTO veiculoCondicao;

    public static  VeiculoDTO from(Veiculo veiculo){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return  modelMapper.map(veiculo, VeiculoDTO.class);
    }
}
