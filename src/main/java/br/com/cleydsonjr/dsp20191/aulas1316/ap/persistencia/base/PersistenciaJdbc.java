package br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.base;

import java.sql.Connection;
import java.sql.Statement;

public class PersistenciaJdbc {

    protected Connection connection = null;
    protected Statement stmt = null;
    private CriaConexao criaConexao = new CriaConexao();
    private String connectionType = "file";

    protected void preparaPersistencia() throws Exception {
        connection = criaConexao.getConnection(connectionType);
        stmt = connection.createStatement();
    }

}
