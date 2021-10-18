package com.br.cooapi.abasteci;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AbasteciTest {
    @Autowired
    private AbasteciRepositories repositories;

    Double teste = 25.6;

    @Test
    public void testSave () {
        AbasteciForm abasteciForm = new AbasteciForm();
        abasteciForm.setVlPago(25.6);

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

}
