package com.br.cooapi.user;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
@Data
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CPF
    private String cpf;
    private String name;
    @Email
    private String email;
    private String phone;
    private String senha;

    public static User from(UserForm userForm){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(userForm, User.class);
    }

}
