package br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.base;

import br.com.cleydsonjr.dsp20191.aulas1316.ap.exceptions.InvalidDataBaseTypeException;

import java.sql.Connection;
import java.sql.DriverManager;

class CriaConexao {

    //JDBC driver name
    private static final String JDBC_DRIVER = "org.h2.Driver";

    //Database file URL
    private static final String DB_FILE_URL = "jdbc:h2:~/lotacao";

    //Database memory URL
    private static final String DB_MEMORY_URL = "jdbc:h2:mem:testdb";

    //Database Credentials
    private static final String USER = "sa";
    private static final String PASS = "";

    Connection getConnection(String connectionType) throws InvalidDataBaseTypeException {
        Connection conn = null;
        try {
            //STEP 1: Register JDBC Driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            if (!connectionType.equalsIgnoreCase("file") && !connectionType.equalsIgnoreCase("memory")) {
                throw new InvalidDataBaseTypeException("O tipo do banco de dados deve ser [file] ou [memory].");
            } else if (connectionType.equalsIgnoreCase("file")) {
                conn = DriverManager.getConnection(DB_FILE_URL, USER, PASS);
            } else {
                conn = DriverManager.getConnection(DB_MEMORY_URL, USER, PASS);
            }

        } catch (Exception se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        return conn;
    }
}
