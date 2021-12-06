package com.br.cooapi.abasteci;


import com.br.cooapi.veiculo.Veiculo;
import com.br.cooapi.veiculo.VeiculoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbasteciRepositories extends JpaRepository<Abasteci, Long> {
    List<Abasteci> findByVeiculos(Veiculo veiculo);
}
