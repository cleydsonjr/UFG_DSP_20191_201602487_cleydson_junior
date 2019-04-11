package br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.ddl;


import br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class TableFuncionarioCreate extends PersistenciaJdbc {

    public boolean criaTabela() throws Exception {
        preparaPersistencia();

        System.out.println("Criando a tabela Funcionario");

        String sql = readSqlFile("/aulas1316/ddl/tabela_funcionario.sql");

        stmt.executeUpdate(sql);

        System.out.println("Tabela Funcionario criada com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }

}
