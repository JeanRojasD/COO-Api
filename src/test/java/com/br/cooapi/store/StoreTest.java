package com.br.cooapi.store;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StoreTest {

    @Autowired
    StoreRepository storeRepository;

    @Test
    @Rollback(false)
    public void verifyStore_HasCreated(){
        StoreForm storeForm = new StoreForm("testing", "testing");
        Store store = storeRepository.save(Store.from(storeForm));

        assertEquals(store.getNome(),storeForm.getNome());
        assertEquals(store.getEndereco(),storeForm.getEndereco());
    }

    @Test
    @Rollback(false)
    public void verifyStore_HasUpdated(){

        StoreForm storeForm = new StoreForm("Casa do Oleo","Avenida JK");

        storeRepository.save(Store.from(storeForm));

        Long findId = 2L;

        StoreForm storeForm1 = new StoreForm("Oleo House", "Morenitas");

        var modelMapper = new ModelMapper();
        Store store = storeRepository.getById(findId);

        modelMapper.map(storeForm1, store);
        Store storeUpdated = storeRepository.save(store);

        assertEquals(storeForm1.getNome(), storeUpdated.getNome());
        assertEquals(storeForm1.getEndereco(), storeUpdated.getEndereco());

    }

    @Test
    @Rollback(false)
    public void verifyStore_HasDeleted(){
        StoreForm storeForm = new StoreForm("Casa do Oleo","Avenida JK");
        storeRepository.save(Store.from(storeForm));
        Long id = 1L;

        boolean existBeforeDelete = storeRepository.findById(id).isPresent();

        storeRepository.deleteById(id);

        boolean notExistAfterDelete = storeRepository.findById(id).isPresent();

        assertTrue(existBeforeDelete);
        assertFalse(notExistAfterDelete);
    }
}
