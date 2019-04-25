package br.com.cleydsonjr.aula2528jpa.persistencia;

import br.com.cleydsonjr.aula2528jpa.model.Veiculo;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PersisteVeiculoTest {

    private VeiculoRepository repository;

    @BeforeTest
    public void setup() {
        repository = new VeiculoRepositoryImpl();
    }

    @Test
    public void TestaPersistenciaVeiculo() throws Exception {
        Veiculo veiculo = new Veiculo("Volkswagen", "Fusca", 1973, 1973, 20);

        Veiculo novoVeiculo = repository.save(veiculo);
        Assert.assertNotNull(novoVeiculo.getId());
    }

}
