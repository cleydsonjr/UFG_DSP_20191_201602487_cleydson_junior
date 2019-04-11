package br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.base;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class PersistenciaJdbc {

    protected Connection connection = null;
    protected Statement stmt = null;
    private CriaConexao criaConexao = new CriaConexao();
    private String connectionType = "file";

    protected void preparaPersistencia() throws Exception {
        connection = criaConexao.getConnection(connectionType);
        stmt = connection.createStatement();
    }

    protected String readSqlFile(String fileName) {
        InputStream resourceAsStream = PersistenciaJdbc.class.getResourceAsStream(fileName);
        Scanner scanner = new Scanner(resourceAsStream, "UTF-8");
        return scanner.useDelimiter("\\A").next();
    }
}
