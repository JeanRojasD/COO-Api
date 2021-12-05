package com.br.cooapi.abasteci;

import com.br.cooapi.veiculo.VeiculoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abasteci")
public class AbasteciController {

    @Autowired
    private AbasteciService abasteciService;

    @GetMapping
    public ResponseEntity<List<AbasteciDto>>findAll(){
        List<AbasteciDto> list = abasteciService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/veiculo/{id}")
    public ResponseEntity<List<AbasteciDto>> findByVeiculo(@PathVariable Long id){
        List<AbasteciDto> list = abasteciService.findByVeiculo(id);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbasteciDto> findById (@PathVariable Long idAbasteci) {
        AbasteciDto abasteci = abasteciService.findById(idAbasteci);
        return ResponseEntity.ok().body(abasteci);
    }

    @PostMapping
    public ResponseEntity<AbasteciDto> create (@RequestBody AbasteciForm obj) {
        return ResponseEntity.ok(abasteciService.create(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AbasteciDto> update (@PathVariable Long id, @RequestBody AbasteciForm obj) {
        return ResponseEntity.ok(abasteciService.update(id, obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        abasteciService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
