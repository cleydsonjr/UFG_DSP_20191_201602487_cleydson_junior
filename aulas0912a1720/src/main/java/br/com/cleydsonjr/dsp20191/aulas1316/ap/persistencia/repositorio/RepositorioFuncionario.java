package br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.repositorio;

import br.com.cleydsonjr.dsp20191.aulas1316.ap.model.Funcionario;
import br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

public class RepositorioFuncionario extends PersistenciaJdbc {

    public boolean persisteFuncionario(Funcionario funcionario) throws Exception {
        preparaPersistencia();

        String sql = "INSERT INTO FUNCIONARIO " +
                "VALUES('" + funcionario.getId() +
                "','" + funcionario.getMatricula() +
                "','" + funcionario.getNome() +
                "')";

        stmt.executeUpdate(sql);
        System.out.println("O Funcionario foi persistido corretamente.");
        stmt.close();
        connection.close();

        return true;
    }
}
