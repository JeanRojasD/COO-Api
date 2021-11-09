package com.br.cooapi.abasteci;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbasteciRepositories extends JpaRepository<Abasteci, Long> {

}
