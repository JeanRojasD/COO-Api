package com.br.cooapi.user;

import com.br.cooapi.SecurityDefaultTest;
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
public class UserIntegrationTest extends SecurityDefaultTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void verify_WhenRequestPost() throws Exception{
        UserForm userForm = UserForm.builder()
                .username("JeanRojas")
                .email("jeanrojas@email.com")
                .cpf("900.356.080-30")
                .password("123fg-c")
                .phone("(45)9992031290")
                .build();

        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userForm)))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void verify_WhenRequestPut() throws Exception{
        UserForm userForm = UserForm.builder()
                .username("JeanRojas")
                .email("jeanrojas@email.com")
                .cpf("900.356.080-30")
                .password("123fg-ceeee")
                .phone("(45)487545157")
                .build();
        mockMvc.perform(put("/users/{id}", 1).contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userForm)))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void verify_WhenRequestHasDelete () throws Exception {
        mockMvc.perform(delete("/users/{id}",1).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
