package br.com.cleydsonjr.dsp20191.aulas1316.ap.init;

import br.com.cleydsonjr.dsp20191.aulas1316.ap.model.Cargo;
import br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.ddl.CriadorEsquema;
import br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.repositorio.RepositorioCargo;

public class Main {

    public static void main(String[] args) {
        CriadorEsquema criadorEsquema = new CriadorEsquema();
        criadorEsquema.crieEsquemaBanco();

        RepositorioCargo repositorioCargo = new RepositorioCargo();

        try {
            Cargo cargo1 = new Cargo(1L, "Cargo 1", 1_000D);
            Cargo cargo2 = new Cargo(2L, "Cargo 2", 1_500D);
            Cargo cargo3 = new Cargo(3L, "Cargo 3", 3_200D);

            repositorioCargo.persisteCargo(cargo1);
            repositorioCargo.persisteCargo(cargo2);
            repositorioCargo.persisteCargo(cargo3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
