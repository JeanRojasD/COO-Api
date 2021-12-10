package com.br.cooapi.user;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {

    private String cpf;
    private String username;
    private String name;
    private String email;
    private String phone;
    private String password;

}
