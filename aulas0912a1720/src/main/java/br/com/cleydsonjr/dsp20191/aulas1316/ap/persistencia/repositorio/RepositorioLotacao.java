package br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.repositorio;

import br.com.cleydsonjr.dsp20191.aulas1316.ap.model.Lotacao;
import br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.base.PersistenciaJdbc;

import java.sql.Date;

public class RepositorioLotacao extends PersistenciaJdbc {

    public boolean persisteLotacao(Lotacao lotacao) throws Exception {
        preparaPersistencia();

        Date dataInicial = new Date(lotacao.getDataInicial().getTime());
        Date dataFinal = new Date(lotacao.getDataFinal().getTime());
        String sql = "INSERT INTO LOTACAO " +
                "VALUES('" + lotacao.getId() +
                "','" + dataInicial +
                "','" + dataFinal +
                "','" + lotacao.getCargo().getId() +
                "','" + lotacao.getDepartamento().getId() +
                "','" + lotacao.getFuncionario().getId() +
                "')";

        stmt.executeUpdate(sql);
        System.out.println("A Lotacao foi persistida corretamente.");
        stmt.close();
        connection.close();

        return true;
    }
}
