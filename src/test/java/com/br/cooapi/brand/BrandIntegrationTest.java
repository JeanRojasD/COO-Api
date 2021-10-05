package com.br.cooapi.brand;

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
public class BrandIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void IntTestCreate () throws Exception {
        BrandForm brandForm = BrandForm.builder().marca("Volkswagen").build();
        mockMvc.perform(post("/brand").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(brandForm)))
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void IntTestUpdate () throws Exception {
        BrandForm brandForm = BrandForm.builder().marca("Ford").build();
        mockMvc.perform(put("/brand/{id}",1).contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(brandForm)))
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void WhenIntTestDelete () throws Exception {
        mockMvc.perform(delete("/brand/{id}",1).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
