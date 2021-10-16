package com.br.cooapi.abasteci;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AbasteciTest {
    @Autowired
    private AbasteciRepositories repositories;

    int teste = 25;

    @Test
    public void testSave () {
        AbasteciForm abasteciForm = new AbasteciForm();
        abasteciForm.setVlPago(25);

        Abasteci abasteci = repositories.save(Abasteci.from(abasteciForm));
        assertEquals(abasteci.getVlPago(), abasteciForm.getVlPago());
    }

    @Test
    public void testUpdatePost () {

        Abasteci abasteci = new Abasteci();
        repositories.save(abasteci);

        Abasteci abasteci1 = repositories.findById(1).get();
        abasteci1.setVlPago(teste);
        Abasteci postUpdate = repositories.save(abasteci1);

        assertEquals(postUpdate.getVlPago(), teste);
    }

    @Test
    public void testDelete(){
        Abasteci abasteci =new Abasteci();

        abasteci.setVlPago(teste);
        repositories.save(abasteci);

        Abasteci abasteci1 =repositories.findById(1).get();

        repositories.delete(abasteci1);

        Abasteci abasteci2 = null;

        Optional<Abasteci>optionalAbasteci = repositories.findByVlPago("teste");

        if(optionalAbasteci.isPresent()){
            abasteci2=optionalAbasteci.get();

        }
        Assertions.assertThat(abasteci2).isNull();

    }

}
