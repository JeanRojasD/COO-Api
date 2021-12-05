package com.br.cooapi.services;

import com.br.cooapi.veiculo.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicesRepository extends JpaRepository<Services, Long> {
    List<Services> findByServices(Veiculo from);
}
