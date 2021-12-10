package com.br.cooapi.user;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Data
public class UserDTO {

    private Long id;
    private String cpf;
    private String username;
    private String name;
    private String email;
    private String phone;

    public static UserDTO from(User user){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(user, UserDTO.class);
    }

}
