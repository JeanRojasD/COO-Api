package com.br.cooapi.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {

    @Autowired
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository){this.storeRepository = storeRepository;}

    public List<StoreDTO> findAll() {
        List<Store> store = storeRepository.findAll();
        return store.stream().map(StoreDTO::from).collect(Collectors.toList());
    }

    public StoreDTO create(StoreForm storeForm) {
        return StoreDTO.from(storeRepository.save(Store.from(storeForm)));
    }

    public StoreDTO update(Long id, StoreForm storeForm){
        Store store = storeRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        store.setNome(storeForm.getNome());
        store.setEndereco(storeForm.getEndereco());
        return StoreDTO.from(storeRepository.save(store));
    }

    public void delete(Long id){
        Store store = storeRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        storeRepository.delete(store);
    }
}
