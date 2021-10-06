package com.br.cooapi.typeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/typeservice")
public class TypeServiceController {

    private final TypeServiceService typeServiceService;

    @Autowired
    private TypeServiceController(TypeServiceService typeServiceService){this.typeServiceService = typeServiceService;}

    @GetMapping
    public ResponseEntity<List<TypeServiceDTO>> findAll(){return ResponseEntity.ok(typeServiceService.findAll());}

    @PostMapping
    public ResponseEntity<TypeServiceDTO> create(@RequestBody @Valid TypeServiceForm typeServiceForm){
        return ResponseEntity.ok(typeServiceService.create(typeServiceForm));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeServiceDTO> update(@PathVariable Long id, @RequestBody @Valid TypeServiceForm typeServiceForm){
        return ResponseEntity.ok(typeServiceService.update(id, typeServiceForm));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        typeServiceService.delete(id);
        return ResponseEntity.ok().build();
    }
}
