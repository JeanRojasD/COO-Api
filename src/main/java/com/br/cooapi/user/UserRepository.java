package com.br.cooapi.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByCpfContaining(String cpf);

    Optional<User> findByEmail(String email);
}
