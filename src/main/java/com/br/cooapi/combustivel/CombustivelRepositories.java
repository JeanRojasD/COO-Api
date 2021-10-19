package com.br.cooapi.combustivel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombustivelRepositories extends JpaRepository<Combustivel, Long> {
}
