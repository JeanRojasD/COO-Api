package com.br.cooapi.combustivel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/combustivel")
public class CombustivelController {
    @Autowired
    private CombustivelService service;

    @GetMapping
    public ResponseEntity<List<CombustivelDto>> findAll () {
        List<CombustivelDto> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CombustivelDto> findById (@PathVariable Long idCombustivel) {
        CombustivelDto combustivel = service.findById(idCombustivel);
        return ResponseEntity.ok().body(combustivel);
    }

    @PostMapping
    public ResponseEntity<CombustivelDto> create (@RequestBody CombustivelForm obj) {
        return ResponseEntity.ok(service.create(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CombustivelDto> update (@PathVariable Long id, @RequestBody CombustivelForm obj) {
        return ResponseEntity.ok(service.update(id, obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
