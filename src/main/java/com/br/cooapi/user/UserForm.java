package com.br.cooapi.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserForm {

    private String cpf;
    private String username;
    private String email;
    private String phone;
    private String password;

}
