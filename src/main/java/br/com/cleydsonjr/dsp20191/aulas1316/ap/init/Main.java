package br.com.cleydsonjr.dsp20191.aulas1316.ap.init;

import br.com.cleydsonjr.dsp20191.aulas1316.ap.model.Cargo;
import br.com.cleydsonjr.dsp20191.aulas1316.ap.model.Departamento;
import br.com.cleydsonjr.dsp20191.aulas1316.ap.model.Funcionario;
import br.com.cleydsonjr.dsp20191.aulas1316.ap.model.Lotacao;
import br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.ddl.CriadorEsquema;
import br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.repositorio.RepositorioCargo;
import br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.repositorio.RepositorioDepartamento;
import br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.repositorio.RepositorioFuncionario;
import br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.repositorio.RepositorioLotacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        CriadorEsquema criadorEsquema = new CriadorEsquema();
        criadorEsquema.crieEsquemaBanco();

        RepositorioCargo repositorioCargo = new RepositorioCargo();
        RepositorioDepartamento repositorioDepartamento = new RepositorioDepartamento();
        RepositorioFuncionario repositorioFuncionario = new RepositorioFuncionario();
        RepositorioLotacao repositorioLotacao = new RepositorioLotacao();

        try {
            Cargo cargo1 = new Cargo(1L, "Cargo 1", 1_000D);
            Cargo cargo2 = new Cargo(2L, "Cargo 2", 1_500D);
            Cargo cargo3 = new Cargo(3L, "Cargo 3", 3_200D);

            repositorioCargo.persisteCargo(cargo1);
            repositorioCargo.persisteCargo(cargo2);
            repositorioCargo.persisteCargo(cargo3);

            Departamento departamento1 = new Departamento(1L, "Departamento 1");
            Departamento departamento2 = new Departamento(2L, "Departamento 2");
            Departamento departamento3 = new Departamento(3L, "Departamento 3");
            Departamento departamento4 = new Departamento(4L, "Departamento 4");

            repositorioDepartamento.persisteDepartamento(departamento1);
            repositorioDepartamento.persisteDepartamento(departamento2);
            repositorioDepartamento.persisteDepartamento(departamento3);
            repositorioDepartamento.persisteDepartamento(departamento4);

            Funcionario funcionario1 = new Funcionario(1L, 100001L, "Funcionario 1");
            Funcionario funcionario2 = new Funcionario(2L, 100002L, "Funcionario 2");
            Funcionario funcionario3 = new Funcionario(3L, 100003L, "Funcionario 3");
            Funcionario funcionario4 = new Funcionario(4L, 100004L, "Funcionario 4");
            Funcionario funcionario5 = new Funcionario(5L, 100005L, "Funcionario 5");
            Funcionario funcionario6 = new Funcionario(6L, 100006L, "Funcionario 6");
            Funcionario funcionario7 = new Funcionario(7L, 100007L, "Funcionario 7");
            Funcionario funcionario8 = new Funcionario(8L, 100008L, "Funcionario 8");
            Funcionario funcionario9 = new Funcionario(9L, 100009L, "Funcionario 9");
            Funcionario funcionario10 = new Funcionario(10L, 100010L, "Funcionario 10");

            repositorioFuncionario.persisteFuncionario(funcionario1);
            repositorioFuncionario.persisteFuncionario(funcionario2);
            repositorioFuncionario.persisteFuncionario(funcionario3);
            repositorioFuncionario.persisteFuncionario(funcionario4);
            repositorioFuncionario.persisteFuncionario(funcionario5);
            repositorioFuncionario.persisteFuncionario(funcionario6);
            repositorioFuncionario.persisteFuncionario(funcionario7);
            repositorioFuncionario.persisteFuncionario(funcionario8);
            repositorioFuncionario.persisteFuncionario(funcionario9);
            repositorioFuncionario.persisteFuncionario(funcionario10);

            Date dataInicial = getDate("01/01/2019");
            Date dataFinal = getDate("31/12/2019");

            Lotacao lotacao1 = new Lotacao(1L, dataInicial, dataFinal, cargo1, departamento1, funcionario1);
            Lotacao lotacao2 = new Lotacao(2L, dataInicial, dataFinal, cargo2, departamento2, funcionario2);
            Lotacao lotacao3 = new Lotacao(3L, dataInicial, dataFinal, cargo3, departamento3, funcionario3);
            Lotacao lotacao4 = new Lotacao(4L, dataInicial, dataFinal, cargo1, departamento4, funcionario4);
            Lotacao lotacao5 = new Lotacao(5L, dataInicial, dataFinal, cargo2, departamento1, funcionario5);
            Lotacao lotacao6 = new Lotacao(6L, dataInicial, dataFinal, cargo3, departamento2, funcionario6);
            Lotacao lotacao7 = new Lotacao(7L, dataInicial, dataFinal, cargo1, departamento3, funcionario7);
            Lotacao lotacao8 = new Lotacao(8L, dataInicial, dataFinal, cargo2, departamento4, funcionario8);
            Lotacao lotacao9 = new Lotacao(9L, dataInicial, dataFinal, cargo3, departamento1, funcionario9);
            Lotacao lotacao10 = new Lotacao(10L, dataInicial, dataFinal, cargo1, departamento2, funcionario10);

            repositorioLotacao.persisteLotacao(lotacao1);
            repositorioLotacao.persisteLotacao(lotacao2);
            repositorioLotacao.persisteLotacao(lotacao3);
            repositorioLotacao.persisteLotacao(lotacao4);
            repositorioLotacao.persisteLotacao(lotacao5);
            repositorioLotacao.persisteLotacao(lotacao6);
            repositorioLotacao.persisteLotacao(lotacao7);
            repositorioLotacao.persisteLotacao(lotacao8);
            repositorioLotacao.persisteLotacao(lotacao9);
            repositorioLotacao.persisteLotacao(lotacao10);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Date getDate(String source) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            return null;
        }
    }

}
