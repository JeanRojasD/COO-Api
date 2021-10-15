package com.br.cooapi.veiculo;

import com.br.cooapi.abasteci.Abasteci;
import com.br.cooapi.model.Model;
import com.br.cooapi.services.Services;
import com.br.cooapi.user.User;
import com.br.cooapi.veiculocondicao.VeiculoCondicao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;
import java.security.Provider;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idveiculo;

    private String placa;
    private Integer ano;

    @ManyToOne
    private Model model;

    @ManyToOne
    private Services services;

    @ManyToOne
    private User user;

    @ManyToOne
    private Abasteci abasteci;

    @ManyToOne
    private VeiculoCondicao veiculoCondicao;



    public static Veiculo from(VeiculoForm veiculoForm) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper.map(veiculoForm, Veiculo.class);
    }


}
