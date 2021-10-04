package com.br.cooapi.model;

import com.br.cooapi.brand.Brand;
import com.br.cooapi.brand.BrandForm;
import com.br.cooapi.brand.BrandRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ModelIntegrationTest {

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void IntTestCreate () throws Exception {
        BrandForm brandForm = new BrandForm("Volkswagen");
        Brand brand = brandRepository.save(Brand.from(brandForm));
        ModelForm modelForm = ModelForm.builder().modelo("Golf").brand(brand).build();
        mockMvc.perform(post("/model").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(modelForm)))
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void IntTestUpdate () throws Exception {
        BrandForm brandForm = new BrandForm("Volkswagen");
        Brand brand = brandRepository.save(Brand.from(brandForm));
        ModelForm modelForm = ModelForm.builder().modelo("Gol").brand(brand).build();
        mockMvc.perform(put("/model/{id}",1).contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(modelForm)))
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void WhenIntTestDelete () throws Exception {
        mockMvc.perform(delete("/model/{id}",1).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
