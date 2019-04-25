package br.com.cleydsonjr.aula2528jpa.persistencia;

import br.com.cleydsonjr.aula2528jpa.model.Veiculo;

import java.util.List;

public interface VeiculoRepository {

    Veiculo get(Long id);

    Veiculo save(Veiculo veiculo) throws Exception;

    List findByMarcaAndModelo(String marca, String modelo);

    Veiculo update(Veiculo veiculo);

    void delete(Veiculo veiculo) throws Exception;

    void close();

}
