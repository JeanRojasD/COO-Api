package com.br.cooapi.typeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeServiceService {

        @Autowired
        private final TypeServiceRepository typeServiceRepository;

        public TypeServiceService(TypeServiceRepository typeServiceRepository){this.typeServiceRepository = typeServiceRepository;}

        public List<TypeServiceDTO> findAll() {
            List<TypeService> typeService = typeServiceRepository.findAll();
            return typeService.stream().map(TypeServiceDTO::from).collect(Collectors.toList());
        }

        public TypeServiceDTO create(TypeServiceForm typeServiceForm) {
            return TypeServiceDTO.from(typeServiceRepository.save(TypeService.from(typeServiceForm)));
        }

        public TypeServiceDTO update(Long id, TypeServiceForm typeServiceForm){
            TypeService typeService = typeServiceRepository.findById(id).orElseThrow(() -> {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            });
            typeService.setNome(typeServiceForm.getNome());
            return TypeServiceDTO.from(typeServiceRepository.save(typeService));
        }

        public void delete(Long id){
            TypeService typeService = typeServiceRepository.findById(id).orElseThrow(() -> {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            });
            typeServiceRepository.delete(typeService);
        }
    }

