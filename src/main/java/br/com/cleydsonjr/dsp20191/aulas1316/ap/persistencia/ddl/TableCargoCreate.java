package br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.ddl;


import br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

class TableCargoCreate extends PersistenciaJdbc {

    void criaTabela() throws Exception {
        preparaPersistencia();

        System.out.println("Criando a tabela Cargo");

        String sql = readSqlFile("/aulas1316/ddl/tabela_cargo.sql");

        stmt.executeUpdate(sql);

        System.out.println("Tabela Cargo criada com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();
    }

}
