package com.br.cooapi.abasteci;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
public class Abasteci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAbastecimento;
    private long precoL;
    private long litroCombustivel;
    private String anotacao;
    private String nomePosto;
    private long vlPago;//valor pago total
    private LocalDateTime dataTime = LocalDateTime.now();

    public static Abasteci from (AbasteciForm abasteciForm) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(abasteciForm, Abasteci.class);
    }
}

