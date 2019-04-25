package br.com.cleydsonjr.aula2528jpa.persistencia;

import br.com.cleydsonjr.aula2528jpa.model.Veiculo;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RemoveVeiculoTest {

    VeiculoRepository repository = null;

    @BeforeTest
    public void setup() {
        repository = new VeiculoRepositoryImpl();
    }

    @Test
    public void deletaVeiculoTeste() throws Exception {

        Veiculo veiculo = repository.get(1L);
        if (veiculo != null) {
            repository.delete(veiculo);
        }
        Veiculo novoVeiculo = repository.get(1L);

        Assert.assertTrue(novoVeiculo == null);
    }


}
