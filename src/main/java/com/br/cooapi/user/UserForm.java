package com.br.cooapi.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserForm {

    private String cpf;
    private String username;
    private String email;
    private String phone;
    private String senha;

}
