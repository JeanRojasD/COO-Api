package com.br.cooapi.combustivel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
public class Combustivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCombustivel;
    private String tCombustivel;

    public static Combustivel from (CombustivelForm combustivelForm) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(combustivelForm, Combustivel.class);
    }
}
