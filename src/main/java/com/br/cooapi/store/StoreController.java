package com.br.cooapi.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    private StoreController(StoreService storeService){this.storeService = storeService;}

    @GetMapping
    public ResponseEntity<List<StoreDTO>> findAll(){return ResponseEntity.ok(storeService.findAll());}

    @PostMapping
    public ResponseEntity<StoreDTO> create(@RequestBody @Valid StoreForm storeForm){
        return ResponseEntity.ok(storeService.create(storeForm));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreDTO> update(@PathVariable Long id, @RequestBody @Valid StoreForm storeForm){
        return ResponseEntity.ok(storeService.update(id, storeForm));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        storeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
