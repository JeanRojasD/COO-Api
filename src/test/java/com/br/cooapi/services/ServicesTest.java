package com.br.cooapi.services;

import com.br.cooapi.store.StoreDTO;
import com.br.cooapi.typeservice.TypeServiceDTO;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ServicesTest {

    @Autowired
    ServicesRepository serviceRepository;

//    @Test
//    @Rollback(false)
//    public void verifyService_HasUpdated(){
//
//        LocalDateTime localDateTime = LocalDateTime.of(2014, 8, 3, 10, 4, 4);
//        StoreDTO loja = new StoreDTO("Casa do Oleo","Rua Morenitas");
//        TypeServiceDTO typeService = new TypeServiceDTO("Manutenção");
//
//        ServicesForm servicesForm = new ServicesForm(100.50,localDateTime,typeService,loja);
//
//        serviceRepository.save(Services.from(servicesForm));
//
//        Long findId = 2L;
//
//        LocalDateTime localDateTime1 = LocalDateTime.of(2015, 5, 10, 19, 1, 1);
//        StoreDTO loja1 = new StoreDTO("Casa do Oleo 2","Rua JK");
//        TypeServiceDTO typeService1 = new TypeServiceDTO("Reparo");
//
//        ServicesForm servicesForm1 = new ServicesForm(300.50,localDateTime1,typeService1,loja1);
//
//        Services service = serviceRepository.getById(findId);
//
//        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.map(servicesForm1, service);
//
//        Services servicesUpdated = serviceRepository.save(service);
//
//        assertEquals(servicesForm1.getValorPago(), servicesUpdated.getValorPago());
//        assertEquals(servicesForm1.getData(), servicesUpdated.getData());
//        assertEquals(servicesForm1.getTpRecebeServico(),servicesUpdated.getTpRecebeServico());
//        assertEquals(servicesForm1.getLoja(),servicesUpdated.getLoja());
//    }

//    @Test
//    @Rollback(false)
//    public void verifyService_HasCreated(){
//
//        LocalDateTime localDateTime = LocalDateTime.of(2018, 7, 22, 10, 15, 30);
//        StoreDTO loja = new StoreDTO("Casa do Óleo","Rua Morenitas");
//        TypeServiceDTO typeService = new TypeServiceDTO("Manutenção");
//
//        ServicesForm servicesForm = new ServicesForm(10.50,localDateTime,typeService,loja);
//
//        Services services = serviceRepository.save(Services.from(servicesForm));
//
//        assertEquals(services.getValorPago(),servicesForm.getValorPago());
//        assertEquals(services.getData(),servicesForm.getData());
//        assertEquals(services.getTpRecebeServico(),servicesForm.getTpRecebeServico());
//        assertEquals(services.getLoja(),servicesForm.getLoja());
//    }
//
//
//    @Test
//    @Rollback(false)
//    public void verifyService_HasDeleted(){
//
//        LocalDateTime localDateTime = LocalDateTime.of(2018, 07, 22, 10, 15, 30);
//        StoreDTO loja = new StoreDTO("Casa do Oleo","Rua Morenitas");
//        TypeServiceDTO typeService = new TypeServiceDTO("Manutenção");
//        ServicesForm servicesForm = new ServicesForm(10.50,localDateTime,typeService,loja);
//
//        serviceRepository.save(Services.from(servicesForm));
//        Long id = 1L;
//
//        boolean existBeforeDelete = serviceRepository.findById(id).isPresent();
//
//        serviceRepository.deleteById(id);
//
//        boolean notExistAfterDelete = serviceRepository.findById(id).isPresent();
//
//        assertTrue(existBeforeDelete);
//        assertFalse(notExistAfterDelete);
//    }
}
