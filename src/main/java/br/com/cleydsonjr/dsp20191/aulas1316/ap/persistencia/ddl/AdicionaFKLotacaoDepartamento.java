package br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.ddl;

import br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class AdicionaFKLotacaoDepartamento extends PersistenciaJdbc {

    public boolean alteraTabela() throws Exception {
        preparaPersistencia();

        System.out.println("Adicionando FK lotacao -> departamento");

        String sql = readSqlFile("/aulas1316/ddl/fk_lotacao_departamento.sql");

        stmt.executeUpdate(sql);

        System.out.println("FK lotacao -> departamento adicionada com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();
        return true;
    }
}
