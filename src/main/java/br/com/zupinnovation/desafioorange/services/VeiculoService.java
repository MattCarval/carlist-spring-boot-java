package br.com.zupinnovation.desafioorange.services;

import br.com.zupinnovation.desafioorange.models.Veiculo;
import br.com.zupinnovation.desafioorange.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    VeiculoRepository veiculoRepository;

    public void insert(Veiculo veiculo){
        veiculoRepository.save(veiculo);
    }

    public Veiculo find(Long id){
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);

        return veiculo.get();
    }

    public List<Veiculo> findAll(){
        List<Veiculo> veiculos = veiculoRepository.findAll();
        return veiculos;
    }

    public void update(Veiculo veiculoAtualizado, Long id){
        Veiculo veiculo = this.find(id);
        veiculo.setMarca(veiculoAtualizado.getMarca());
        veiculo.setModelo(veiculoAtualizado.getModelo());
        veiculo.setAno(veiculoAtualizado.getAno());
        veiculo.setValor(veiculoAtualizado.getValor());
        this.insert(veiculo);
    }

    public void delete(Long id){
        veiculoRepository.deleteById(id);
    }

}
