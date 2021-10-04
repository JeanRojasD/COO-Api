package com.br.cooapi.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ModelTest {

    @Autowired
    private ModelRepository modelRepository;

    @Test
    @Rollback(false)
    public void TestCreate(){
        ModelForm modelForm = new ModelForm("Golf");
        Model model = modelRepository.save(Model.from(modelForm));
        assertEquals(model.getModelo(), modelForm.getModelo());
    }
    @Test
    @Rollback(false)
    public void TestUpdate() {
        String modelo1 = "Camaro";
        ModelForm modelForm = new ModelForm("Golf");
        Model model = modelRepository.save(Model.from(modelForm));
        modelRepository.findById(1L).get();
        model.setModelo(modelo1);
        modelRepository.save(model);
        assertEquals(model.getModelo(),modelo1);
    }
    @Test
    @Rollback(false)
    public void TestDelete(){
        ModelForm modelForm = new ModelForm("Golf");
        modelRepository.save(Model.from(modelForm));
        Long id = 2L;
        Boolean present1 = modelRepository.findById(id).isPresent();
        modelRepository.deleteById(id);
        Boolean present2 = modelRepository.findById(id).isPresent();
        assertTrue(present1);
        assertFalse(present2);
    }
}
