package com.br.cooapi.user;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @Rollback(false)
    public void verifyUser_WhenHasCreated() {
        UserForm userForm = new UserForm("09510077933", "Jean", "jeanrojas@email.com", "9955588744", "jean12345");

        User userFinal = userRepository.save(User.from(userForm));

        assertEquals(userFinal.getCpf(), userForm.getCpf());
        assertEquals(userFinal.getName(), userForm.getName());
    }

    @Test
    void verifyUser_WhenHasUpdated() {

        UserForm userSaveForm = new UserForm("09510077933", "Jean", "jeanrojas@email.com", "9955588744", "jean12345");

        Long searchId = 1L;

        userRepository.save(User.from(userSaveForm));

        UserForm userForm = new UserForm("17253214927", "Jean", "jeanrojas@email.com", "9955588744", "jean12345");

        var modelMapper = new ModelMapper();
        User userFound = userRepository.getById(searchId);

        modelMapper.map(userForm, userFound);
        User userFinal = userRepository.save(userFound);

        assertEquals(userForm.getName(), userFinal.getName());
        assertEquals(userFinal.getCpf(), userForm.getCpf());

    }

    @Test
    void verifyUser_WhenHasDeleted() {
        UserForm userSaveForm = new UserForm("09510077933", "Jean", "jeanrojas@email.com", "9955588744", "jean12345");

        userRepository.save(User.from(userSaveForm));

        Long id = 1L;

        boolean isExistBeforeDelete = userRepository.findById(id).isPresent();

        userRepository.deleteById(id);

        boolean notExistAfterDelete = userRepository.findById(id).isPresent();

        assertTrue(isExistBeforeDelete);
        assertFalse(notExistAfterDelete);

    }
}