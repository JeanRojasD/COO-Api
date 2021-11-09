package com.br.cooapi.abasteci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abasteci")
public class AbasteciController {
    @Autowired
    private AbasteciService service;

    @GetMapping
    public ResponseEntity<List<AbasteciDto>>findAll(){
        List<AbasteciDto> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbasteciDto> findById (@PathVariable Long idAbasteci) {
        AbasteciDto abasteci = service.findById(idAbasteci);
        return ResponseEntity.ok().body(abasteci);
    }

    @PostMapping
    public ResponseEntity<AbasteciDto> create (@RequestBody AbasteciForm obj) {
        return ResponseEntity.ok(service.create(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AbasteciDto> update (@PathVariable Long id, @RequestBody AbasteciForm obj) {
        return ResponseEntity.ok(service.update(id, obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
