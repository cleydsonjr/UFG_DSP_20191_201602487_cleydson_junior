package br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.repositorio;

import br.com.cleydsonjr.dsp20191.aulas1316.ap.model.Departamento;
import br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class RepositorioDepartamento extends PersistenciaJdbc {

    public boolean persisteDepartamento(Departamento departamento) throws Exception {
        preparaPersistencia();

        String sql = "INSERT INTO DEPARTAMENTO " +
                "VALUES('" + departamento.getId() +
                "','" + departamento.getNome() +
                "')";

        stmt.executeUpdate(sql);
        System.out.println("O Departamento foi persistido corretamente.");
        stmt.close();
        connection.close();

        return true;
    }
}
