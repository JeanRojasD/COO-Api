package com.br.cooapi.user;

import lombok.Data;

@Data
public class UserForm {

    private String cpf;
    private String name;
    private String email;
    private String phone;
    private String senha;

}
