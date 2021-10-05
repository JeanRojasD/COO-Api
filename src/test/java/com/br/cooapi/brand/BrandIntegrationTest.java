package com.br.cooapi.brand;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BrandIntegrationTest {

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
