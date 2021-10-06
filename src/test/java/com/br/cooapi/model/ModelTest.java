package com.br.cooapi.model;

import com.br.cooapi.brand.Brand;
import com.br.cooapi.brand.BrandDTO;
import com.br.cooapi.brand.BrandForm;
import com.br.cooapi.brand.BrandRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ModelTest {

    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @Rollback(false)
    public void TestCreate(){
        BrandForm brandForm = new BrandForm("Volkswagen");
        Brand brand = brandRepository.save(Brand.from(brandForm));
        ModelForm modelForm = new ModelForm("Golf", BrandDTO.from(brand));
        Model model = modelRepository.save(Model.from(modelForm));
        assertEquals(model.getModelo(), modelForm.getModelo());
    }
    @Test
    @Rollback(false)
    public void TestUpdate() {
        String modelo1 = "Camaro";
        BrandForm brandForm = new BrandForm("Volkswagen");
        Brand brand = brandRepository.save(Brand.from(brandForm));
        ModelForm modelForm = new ModelForm("Golf", BrandDTO.from(brand));
        Model model = modelRepository.save(Model.from(modelForm));
        modelRepository.findById(1L).get();
        model.setModelo(modelo1);
        modelRepository.save(model);
        assertEquals(model.getModelo(),modelo1);
    }
    @Test
    @Rollback(false)
    public void TestDelete(){
        BrandForm brandForm = new BrandForm("Volkswagen");
        Brand brand = brandRepository.save(Brand.from(brandForm));
        ModelForm modelForm = new ModelForm("Golf", BrandDTO.from(brand));
        modelRepository.save(Model.from(modelForm));
        Long id = 1L;
        Boolean present1 = modelRepository.findById(id).isPresent();
        modelRepository.deleteById(id);
        Boolean present2 = modelRepository.findById(id).isPresent();
        assertTrue(present1);
        assertFalse(present2);
    }
}
