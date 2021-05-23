package br.com.zupinnovation.desafioorange.repositories;

import br.com.zupinnovation.desafioorange.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
