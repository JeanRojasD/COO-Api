package com.br.cooapi.user;

import com.br.cooapi.config.ModelMapperConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    private ModelMapperConf modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapperConf modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDTO::from).collect(Collectors.toList());
    }

    public UserDTO create(UserForm userForm) {
        return UserDTO.from(userRepository.save(User.from(userForm)));
    }

    public UserDTO update(Long id, UserForm userForm){
        User userFound = userRepository.findById(id).orElseThrow(() -> {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        modelMapper.modelMapper().map(userForm, userFound);

        return UserDTO.from(userRepository.save(userFound));
    }

    public void delete(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        userRepository.delete(user);

    }
}
