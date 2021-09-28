package com.br.cooapi.brand;

import com.br.cooapi.model.Model;
import com.br.cooapi.model.ModelForm;
import com.br.cooapi.model.ModelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;


    import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BrandTest {

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ModelRepository modelRepository;

    @Test
    @Rollback(false)
    public void TestCreate(){
        ModelForm modelForm = new ModelForm("Gol");
        Model model = modelRepository.save(Model.from(modelForm));
        BrandForm brandForm = new BrandForm("Volkswagen", model);
        Brand brand = brandRepository.save(Brand.from(brandForm));
        assertEquals(brand.getMarca(), brandForm.getMarca());
    }
    @Test
    @Rollback(false)
    public void testUpdate(){
        String marca1 = "Ford";
        ModelForm modelForm = new ModelForm("Gol");
        Model model = modelRepository.save(Model.from(modelForm));
        BrandForm brandForm = new BrandForm("Volkswagen", model);
        Brand brand = brandRepository.save(Brand.from(brandForm));
        brandRepository.findById(1L).get();
        brand.setMarca(marca1);
        brandRepository.save(brand);
        assertEquals(brand.getMarca(), marca1);
    }
    @Test
    @Rollback(false)
    public void testDelete(){
        ModelForm modelForm = new ModelForm("Gol");
        Model model = modelRepository.save(Model.from(modelForm));
        BrandForm brandForm = new BrandForm("Volkswagen", model);
        brandRepository.save(Brand.from(brandForm));
        Long id = 1L;
        Boolean present1 = brandRepository.findById(id).isPresent();
        brandRepository.deleteById(id);
        Boolean present2 = brandRepository.findById(id).isPresent();
        assertTrue(present1);
        assertFalse(present2);
    }
}
