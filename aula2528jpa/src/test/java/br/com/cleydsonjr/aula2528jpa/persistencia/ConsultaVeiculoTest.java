package br.com.cleydsonjr.aula2528jpa.persistencia;

import br.com.cleydsonjr.aula2528jpa.model.Veiculo;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ConsultaVeiculoTest {

    private VeiculoRepository repository;

    @BeforeTest
    public void setup() {
        repository = new VeiculoRepositoryImpl();
    }

    @Test
    public void consultaVeiculoPeloId() {
        Veiculo veiculo = repository.get(1L);
        System.out.println("Modelo do veiculo: " + veiculo.getModelo());
        Assert.assertTrue(veiculo != null);
    }

}
