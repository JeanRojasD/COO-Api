package com.br.cooapi.abasteci;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AbasteciRepositories extends JpaRepository<Abasteci, Integer> {

    Optional<Abasteci> findByVlPago (String teste);
}
