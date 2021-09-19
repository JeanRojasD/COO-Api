package com.br.cooapi.user;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String cpf;
    private String name;
    private String email;
    private String phone;

}
