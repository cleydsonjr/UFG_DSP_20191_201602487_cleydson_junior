package br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.repositorio;

import br.com.cleydsonjr.dsp20191.aulas1316.ap.model.Cargo;
import br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class RepositorioCargo extends PersistenciaJdbc {

    public boolean persisteCargo(Cargo cargo) throws Exception {
        preparaPersistencia();

        String sql = "INSERT INTO CARGO " +
                "VALUES('" + cargo.getId() +
                "','" + cargo.getNome() +
                "','" + cargo.getSalario() +
                "')";

        stmt.executeUpdate(sql);
        System.out.println("O Cargo foi persistido corretamente.");
        stmt.close();
        connection.close();

        return true;
    }
}
