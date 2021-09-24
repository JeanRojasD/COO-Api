package com.br.cooapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {

    private ServicesService servicesService;

    @Autowired
    public ServicesController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @GetMapping
    public ResponseEntity<List<ServicesDTO>> findAll(){
        return ResponseEntity.ok(servicesService.findAll());
    }

    @PostMapping
    public ResponseEntity<ServicesDTO> create(@RequestBody @Valid ServicesForm servicesForm){
        return ResponseEntity.ok(servicesService.create(servicesForm));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicesDTO> update(@PathVariable Long id, @RequestBody @Valid ServicesForm servicesForm){
        return ResponseEntity.ok(servicesService.update(id, servicesForm));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        servicesService.delete(id);
        return ResponseEntity.ok().build();
    }
    
    
}
