package com.br.cooapi.services;

import com.br.cooapi.store.Store;
import com.br.cooapi.typeservice.TypeService;
import com.br.cooapi.veiculo.Veiculo;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valorPago;
    @ManyToOne
    private Veiculo veiculo;
    private LocalDateTime data;

    @ManyToOne
    private TypeService tpRecebeServico;
    @ManyToOne
    private Store loja;

    public static Services from(ServicesForm servicesForm) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(servicesForm, Services.class);
    }
}
