package com.br.cooapi.abasteci;

import com.br.cooapi.combustivel.Combustivel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
public class Abasteci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAbastecimento;
    private Double vlPago;
    private LocalDateTime dataTime = LocalDateTime.now();

    @ManyToOne
    private Combustivel combustivel;

    public static Abasteci from (AbasteciForm abasteciForm) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(abasteciForm, Abasteci.class);
    }
}

