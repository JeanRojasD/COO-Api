package com.br.cooapi.veiculocondicao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/veiculocondicao")
public class VeiculoCondicaoController {

    private final VeiculoCondicaoService veiculoCondicaoService;

    @Autowired
    public VeiculoCondicaoController(VeiculoCondicaoService veiculoCondicaoService) {
        this.veiculoCondicaoService = veiculoCondicaoService;
    }

    @GetMapping
    public ResponseEntity<List<VeiculoCondicaoDTO>> findAll(){return ResponseEntity.ok(veiculoCondicaoService.findAll());}

    @PostMapping
    public ResponseEntity<VeiculoCondicaoDTO> create(@RequestBody @Valid VeiculoCondicaoForm veiculoCondicaoForm){
        return ResponseEntity.ok(veiculoCondicaoService.create(veiculoCondicaoForm));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoCondicaoDTO> update(@PathVariable Long id, @RequestBody @Valid VeiculoCondicaoForm veiculoCondicaoForm){
        return ResponseEntity.ok(veiculoCondicaoService.update(id,veiculoCondicaoForm));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        veiculoCondicaoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
