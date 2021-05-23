package br.com.zupinnovation.desafioorange.services;

import br.com.zupinnovation.desafioorange.models.Usuario;
import br.com.zupinnovation.desafioorange.models.Veiculo;
import br.com.zupinnovation.desafioorange.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    VeiculoService veiculoService;

    public void insert(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public Usuario find(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        return usuario.get();
    }

    public List<Usuario> findAll(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    public void update(Usuario usuarioAtualizado, Long userId){
        Usuario usuario = this.find(userId);
        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setCpf(usuarioAtualizado.getCpf());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setDtNasc(usuarioAtualizado.getDtNasc());
        this.insert(usuario);
    }

    public void delete(Long id){
        usuarioRepository.deleteById(id);
    }

    public void addVeiculo(Long userId, Long veiculoId) {
        Usuario objUsuario = this.find(userId);
        Veiculo objVeiculo = veiculoService.find(veiculoId);
        objUsuario.addVeiculo(objVeiculo);
        this.update(objUsuario, userId);
    }
}
