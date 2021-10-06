package com.br.cooapi.model;

import com.br.cooapi.brand.Brand;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;

@Entity
@Data
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public static Model from (ModelForm modelForm){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(modelForm, Model.class);
    }
}
