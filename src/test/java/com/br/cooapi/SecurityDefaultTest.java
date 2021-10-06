package com.br.cooapi;

import com.br.cooapi.config.security.SecurityTestProfile;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Import({
        SecurityTestProfile.class
})
public class SecurityDefaultTest {
}
