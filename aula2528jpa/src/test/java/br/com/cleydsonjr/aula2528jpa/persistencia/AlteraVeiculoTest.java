package br.com.cleydsonjr.aula2528jpa.persistencia;

import br.com.cleydsonjr.aula2528jpa.model.Veiculo;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlteraVeiculoTest {

    private VeiculoRepository repository = null;

    @BeforeTest
    public void setup() {
        repository = new VeiculoRepositoryImpl();
    }

    @Test
    public void alteraNomeTeste() {
        Veiculo veiculo = repository.get(1L);

        veiculo.setPotenciaMotor(200);

        repository.update(veiculo);

        Assert.assertEquals(new Integer(200), veiculo.getPotenciaMotor());
    }


}
