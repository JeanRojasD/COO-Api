package com.br.cooapi.veiculotest;

import com.br.cooapi.veiculo.Veiculo;
import com.br.cooapi.veiculo.VeiculoForm;
import com.br.cooapi.veiculo.VeiculoRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VeiculoTestInt {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

//    @Test
//    public void VeiculoCreate () throws Exception {
//
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        VeiculoForm veiculoForm = VeiculoForm.builder().placa("123-mkda").ano(2001).build();
//        mockMvc.perform(post("/veiculo").contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(veiculoForm)))
//                .andExpect(status().isOk())
//                .andReturn();
//
//
//    }

}
