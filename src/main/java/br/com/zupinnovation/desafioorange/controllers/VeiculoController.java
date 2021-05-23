package br.com.zupinnovation.desafioorange.controllers;

import br.com.zupinnovation.desafioorange.models.Veiculo;
import br.com.zupinnovation.desafioorange.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;

    @PostMapping("/veiculo")
    public ResponseEntity<?> insert(@RequestBody Veiculo veiculo){
        veiculoService.insert(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro de usuário realizado com sucesso!");
    }

    @GetMapping("/veiculo/{id}")
    public ResponseEntity<?> getVeiculoById(@PathVariable Long id){
        Veiculo veiculo = veiculoService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(veiculo);
    }

    @GetMapping("/veiculos")
    public ResponseEntity<?> findAll(){
        List<Veiculo> veiculos = veiculoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(veiculos);
    }

    @PutMapping("veiculo/{id}")
    public ResponseEntity<?> update(@RequestBody Veiculo veiculo, @PathVariable Long id){
        veiculoService.update(veiculo, id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário atualizado com sucesso!");
    }

    @DeleteMapping("veiculo/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        veiculoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso!");
    }
}
