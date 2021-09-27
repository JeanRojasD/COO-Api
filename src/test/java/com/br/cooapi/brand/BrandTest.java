package com.br.cooapi.brand;

import com.br.cooapi.config.ModelMapperConf;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.xml.stream.events.Comment;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BrandTest {

    @Autowired
    private BrandRepository brandRepository;

    @Test
    @Rollback(false)
    public void TestCreate(){
        BrandForm brandForm = new BrandForm("Volkswagen");
        Brand brand = brandRepository.save(Brand.from(brandForm));

        assertEquals(brand.getMarca(), brandForm.getMarca());
    }

    @Test
    public void testUpdate(){
        String marca1 = "Ford";
        BrandForm brandForm = new BrandForm("Volkswagen");
        Brand brand = brandRepository.save(Brand.from(brandForm));
        brandRepository.findById(1L).get();
        brand.setMarca(marca1);
        Brand brand2 = brandRepository.save(brand);
        assertEquals(brand2.getMarca(), marca1);

    }
    @Test
    public void testDelete(){
        BrandForm brandForm = new BrandForm("Volkswagen");
        Brand brand = brandRepository.save(Brand.from(brandForm));
        Long id = 1L;
        Boolean present1 = brandRepository.findById(id).isPresent();
        brandRepository.deleteById(id);
        Boolean present2 = brandRepository.findById(id).isPresent();
        assertTrue(present1);
        assertFalse(present2);
    }
}
