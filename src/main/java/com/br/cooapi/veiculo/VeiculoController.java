package com.br.cooapi.veiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<VeiculoDTO> create (@RequestBody @Validated VeiculoForm veiculoForm){
        return ResponseEntity.ok(veiculoService.Create(veiculoForm));
    }

    @GetMapping
    public ResponseEntity<Page<VeiculoDTO>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable pageable){
        return ResponseEntity.ok(veiculoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(veiculoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoDTO> update(@PathVariable Long id, @RequestBody @Validated VeiculoForm veiculoForm){
        return  ResponseEntity.ok(veiculoService.update(veiculoForm, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        veiculoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
