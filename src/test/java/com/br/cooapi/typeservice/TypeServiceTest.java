package com.br.cooapi.typeservice;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TypeServiceTest {

    @Autowired
    TypeServiceRepository typeServiceRepository;

    @Test
    @Rollback(false)
    public void verifyTypeService_HasCreated(){
        TypeServiceForm typeServiceForm = new TypeServiceForm("Manutenção");
        TypeService typeService = typeServiceRepository.save(TypeService.from(typeServiceForm));

        assertEquals(typeService.getNome(),typeService.getNome());
    }

    @Test
    @Rollback(false)
    public void verifyTypeService_HasUpdated(){

        TypeServiceForm typeServiceForm = new TypeServiceForm("Manutenção");
        TypeServiceForm typeServiceForm1 = new TypeServiceForm("Reparo");
        typeServiceRepository.save(TypeService.from(typeServiceForm));
        Long findId = 2L; 
        ModelMapper modelMapper = new ModelMapper();
        TypeService typeService = typeServiceRepository.getById(findId);
        modelMapper.map(typeServiceForm, typeService);
        typeServiceRepository.save(typeService);
        assertEquals(typeServiceForm.getNome(), typeService.getNome());
    }

    @Test
    @Rollback(false)
    public void verifyTypeService_HasDeleted(){
        TypeServiceForm typeServiceForm = new TypeServiceForm("Manutenção");
        typeServiceRepository.save(TypeService.from(typeServiceForm));
        Long id = 1L;

        boolean existBeforeDelete = typeServiceRepository.findById(id).isPresent();
        typeServiceRepository.deleteById(id);
        boolean notExistAfterDelete = typeServiceRepository.findById(id).isPresent();

        assertTrue(existBeforeDelete);
        assertFalse(notExistAfterDelete);
    }

}
