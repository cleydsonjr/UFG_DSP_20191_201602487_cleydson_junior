package br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.ddl;

public class CriadorEsquema {

    public void crieEsquemaBanco() {
        try {
            new TableCargoCreate().criaTabela();
            new TableDepartamentoCreate().criaTabela();
            new TableFuncionarioCreate().criaTabela();
            new TableLotacaoCreate().criaTabela();
            new AdicionaFKLotacaoCargo().alteraTabela();
            new AdicionaFKLotacaoDepartamento().alteraTabela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
