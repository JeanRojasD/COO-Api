package com.br.cooapi.veiculotest;

import com.br.cooapi.veiculo.Veiculo;
import com.br.cooapi.veiculo.VeiculoForm;
import com.br.cooapi.veiculo.VeiculoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.junit.ExceptionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VeiculoServiceTest {

    @Autowired
    VeiculoRepository veiculoRepository;

    @Test
    public void placatest () {

        VeiculoForm veiculoForm = new VeiculoForm("123-abcd", 2001);
        veiculoRepository.save(Veiculo.from(veiculoForm));

        VeiculoForm veiculoForm1 = new VeiculoForm("123-abgd", 2010);

        if (veiculoRepository.findByPlacaContaining(veiculoForm1.getPlaca()).isPresent()) {

            veiculoForm1 = null;
            ResponseEntity.internalServerError();

        } else {
            veiculoRepository.save(Veiculo.from(veiculoForm1));
        }

            Assert.assertEquals( veiculoRepository.findById(2L).get().getPlaca(), veiculoForm1.getPlaca() );
    }

}

