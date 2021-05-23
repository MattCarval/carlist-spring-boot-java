package br.com.zupinnovation.desafioorange.repositories;

import br.com.zupinnovation.desafioorange.models.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
