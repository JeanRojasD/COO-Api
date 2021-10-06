package com.br.cooapi.user;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @Rollback(false)
    public void verifyUser_WhenHasCreated() {
        UserForm userForm = new UserForm("21584812001", "Jean", "jeanrojas@email.com", "9955588744", "jean12345");

        User userFinal = userRepository.save(User.from(userForm));

        assertEquals(userFinal.getCpf(), userForm.getCpf());
        assertEquals(userFinal.getUsername(), userForm.getUsername());
    }

//    @Test
//    @Rollback(false)
//    public void verifyUser_WhenCpfIsDuplicated(){
//        UserForm userForm = new UserForm("21584812001", "Jean", "jeanrojas@email.com", "9955588744", "jean12345");
//
//        userRepository.save(User.from(userForm));
//
//        UserForm userFormCpfDuplicated = new UserForm("21584812001", "Jean", "jeanrojas@email.com", "9955588744", "jean12345");
//
//        if (userRepository.findByCpfContaining(userForm.getCpf()).isPresent()){
//            throw new RuntimeException("error");
//        }
//
//    }


    @Test
    public void verifyUser_WhenHasUpdated() {

        UserForm userSaveForm = new UserForm("21584812001", "Jean", "jeanrojas@email.com", "9955588744", "jean12345");

        Long searchId = 1L;

        userRepository.save(User.from(userSaveForm));

        UserForm userForm = new UserForm("21584812001", "Jean", "jeanrojas@email.com", "9955588744", "jean12345");

        var modelMapper = new ModelMapper();
        User userFound = userRepository.getById(searchId);

        modelMapper.map(userForm, userFound);
        User userFinal = userRepository.save(userFound);

        assertEquals(userForm.getUsername(), userFinal.getUsername());
        assertEquals(userFinal.getCpf(), userForm.getCpf());

    }

    @Test
    public void verifyUser_WhenHasDeleted() {
        UserForm userSaveForm = new UserForm("21584812001", "Jean", "jeanrojas@email.com", "9955588744", "jean12345");

        userRepository.save(User.from(userSaveForm));

        Long id = 1L;

        boolean isExistBeforeDelete = userRepository.findById(id).isPresent();

        userRepository.deleteById(id);

        boolean notExistAfterDelete = userRepository.findById(id).isPresent();

        assertTrue(isExistBeforeDelete);
        assertFalse(notExistAfterDelete);

    }
}