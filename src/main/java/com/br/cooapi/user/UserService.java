package com.br.cooapi.user;

import com.br.cooapi.config.ModelMapperConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    private ModelMapperConf modelMapper;

    Logger logger = LoggerFactory.getLogger(UserService.class);

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
        if (userRepository.findByCpfContaining(userForm.getCpf()).isPresent()){
            logger.error("Cpf already exists {}", userForm.getCpf());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cpf já cadastrado");
        }
        if (userRepository.findByEmail(userForm.getEmail()).isPresent()){
            logger.error("Email already exists {}", userForm.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já cadastrado");
        }

        return UserDTO.from(userRepository.save(User.from(userForm)));
    }

    public UserDTO update(Long id, UserForm userForm){
        User userFound = userRepository.findById(id).orElseThrow(() -> {
            logger.error("Id not found {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        modelMapper.modelMapper().map(userForm, userFound);

        return UserDTO.from(userRepository.save(userFound));
    }

    public void delete(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> {
            logger.error("Id not found {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        userRepository.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
