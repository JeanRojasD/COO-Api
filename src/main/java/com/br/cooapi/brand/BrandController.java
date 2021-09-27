package com.br.cooapi.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    private BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }
    @GetMapping
    public ResponseEntity<List<BrandDTO>> findAll(){
        return ResponseEntity.ok(brandService.findAll());
    }
    @PostMapping
    public ResponseEntity<BrandDTO> create(@RequestBody @Valid BrandForm brandForm){
        return ResponseEntity.ok(brandService.create(brandForm));
    }
    @PutMapping("/{id}")
    public ResponseEntity<BrandDTO> update(@PathVariable Long id,@RequestBody @Valid BrandForm brandForm){
        return ResponseEntity.ok(brandService.update(id, brandForm));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        brandService.delete(id);
        return ResponseEntity.ok().build();
    }
}
