package com.br.cooapi.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelController {

    private ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }
    @GetMapping
    public ResponseEntity<List<ModelDTO>> findAll(){
        return ResponseEntity.ok(modelService.findAll());
    }
    @PostMapping
    public ResponseEntity<ModelDTO> create(@RequestBody @Valid ModelForm modelForm){
        return ResponseEntity.ok(modelService.create(modelForm));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ModelDTO> update(@PathVariable Long id, @RequestBody @Valid ModelForm modelForm){
        return ResponseEntity.ok(modelService.update(id, modelForm));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        modelService.delete(id);
        return ResponseEntity.ok().build();
    }
}
