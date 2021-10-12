package com.br.cooapi.veiculocondicao;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VeiculoCondicaoTest {

    @Autowired
    VeiculoCondicaoRepository veiculoCondicaoRepository;

    @Test
    @Rollback(false)
    public void verifyVeiculoCondicao_HasCreated(){
        VeiculoCondicaoForm veiculoCondicaoForm = new VeiculoCondicaoForm("Novo");
        VeiculoCondicao veiculoCondicao = veiculoCondicaoRepository.save(VeiculoCondicao.from(veiculoCondicaoForm));

        assertEquals(veiculoCondicao.getCondicao(),veiculoCondicao.getCondicao());
    }

    @Test
    @Rollback(false)
    public void verifyVeiculoCondicao_HasUpdated(){

        VeiculoCondicaoForm veiculoCondicaoForm = new VeiculoCondicaoForm("Novo");
        veiculoCondicaoRepository.save(VeiculoCondicao.from(veiculoCondicaoForm));
        Long findId = 1L;
        ModelMapper modelMapper = new ModelMapper();
        VeiculoCondicao veiculoCondicao = veiculoCondicaoRepository.getById(findId);
        modelMapper.map(veiculoCondicaoForm, veiculoCondicao);
        veiculoCondicaoRepository.save(veiculoCondicao);
        assertEquals(veiculoCondicaoForm.getCondicao(), veiculoCondicao.getCondicao());
    }

    @Test
    @Rollback(false)
    public void verifyVeiculoCondicao_HasDeleted(){
        VeiculoCondicaoForm veiculoCondicaoForm = new VeiculoCondicaoForm("Novo");
        veiculoCondicaoRepository.save(VeiculoCondicao.from(veiculoCondicaoForm));
        Long id = 2L;

        boolean existBeforeDelete = veiculoCondicaoRepository.findById(id).isPresent();
        veiculoCondicaoRepository.deleteById(id);
        boolean notExistAfterDelete = veiculoCondicaoRepository.findById(id).isPresent();

        assertTrue(existBeforeDelete);
        assertFalse(notExistAfterDelete);
    }
}
