package com.br.cooapi.brand;

import com.br.cooapi.model.Model;
import com.br.cooapi.model.ModelForm;
import com.br.cooapi.model.ModelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;


    import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BrandTest {

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    @Rollback(false)
    public void TestCreate(){
        BrandForm brandForm = new BrandForm("Volkswagen");
        Brand brand = brandRepository.save(Brand.from(brandForm));
        assertEquals(brand.getMarca(), brandForm.getMarca());
    }
    @Test
    @Rollback(false)
    public void testUpdate(){
        String marca1 = "Ford";
        BrandForm brandForm = new BrandForm("Volkswagen");
        Brand brand = brandRepository.save(Brand.from(brandForm));
        brandRepository.findById(1L).get();
        brand.setMarca(marca1);
        brandRepository.save(brand);
        assertEquals(brand.getMarca(), marca1);
    }
    @Test
    @Rollback(false)
    public void testDelete(){
        BrandForm brandForm = new BrandForm("Volkswagen");
        brandRepository.save(Brand.from(brandForm));
        Long id = 1L;
        Boolean present1 = brandRepository.findById(id).isPresent();
        brandRepository.deleteById(id);
        Boolean present2 = brandRepository.findById(id).isPresent();
        assertTrue(present1);
        assertFalse(present2);
    }
    @Test
    @Rollback(false)
    public void intTestCreate(){
        BrandForm brandForm = new BrandForm("Volkswagen");
        Brand brand = brandRepository.save(Brand.from(brandForm));
        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:8080/brand/", brand, String.class);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }
    @Test
    @Rollback(false)
    public void intTestUpdate(){
        String marca1 = "Ford";
        BrandForm brandForm = new BrandForm("Volkswagen");
        Brand brand = brandRepository.save(Brand.from(brandForm));
        brandRepository.findById(1L).get();
        brand.setMarca(marca1);
        brandRepository.save(brand);
        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:8080/brand/", brand, String.class);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }
    @Test
    @Rollback(false)
    public void intTestDelete(){
        BrandForm brandForm = new BrandForm("Volkswagen");
        Brand brand = brandRepository.save(Brand.from(brandForm));
        Long id = 1L;
        brandRepository.deleteById(id);
        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:8080/brand/", brand, String.class);
        assertEquals(500, responseEntity.getStatusCodeValue());
    }
}
