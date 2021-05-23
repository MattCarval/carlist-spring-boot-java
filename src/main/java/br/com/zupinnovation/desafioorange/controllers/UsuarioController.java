package br.com.zupinnovation.desafioorange.controllers;

import br.com.zupinnovation.desafioorange.models.Usuario;
import br.com.zupinnovation.desafioorange.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/usuario")
    public ResponseEntity<?> insert(@RequestBody Usuario usuario){
        try{
            usuarioService.insert(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro de usuário realizado com sucesso!");
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable Long id){
        try{
            Usuario usuario = usuarioService.find(id);
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha na busca, verifique o código do usuário");
        }
    }

    @GetMapping("/usuarios")
    public ResponseEntity<?> findAll(){
        try {
            List<Usuario> usuarios = usuarioService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(usuarios);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("usuario/{id}")
    public ResponseEntity<?> update(@RequestBody Usuario usuario, @PathVariable Long id){
        try {
            usuarioService.update(usuario, id);
            return ResponseEntity.status(HttpStatus.OK).body("Usuário atualizado com sucesso!");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("usuario/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            usuarioService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso!");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("usuario/{userId}/veiculo/{veiculoId}")
    public ResponseEntity<?> addVeiculo(@PathVariable Long userId, @PathVariable Long veiculoId){
        try{
            usuarioService.addVeiculo(userId, veiculoId);
            return ResponseEntity.status(HttpStatus.OK).body("Veiculo adicionado ao usuario com sucesso!");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha na busca, verifique o código do usuário e do veículo");
        }
    }
}
