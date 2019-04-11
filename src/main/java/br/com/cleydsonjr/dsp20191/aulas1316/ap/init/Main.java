package br.com.cleydsonjr.dsp20191.aulas1316.ap.init;

import br.com.cleydsonjr.dsp20191.aulas1316.ap.persistencia.ddl.CriadorEsquema;

public class Main {

    public static void main(String[] args) {
        CriadorEsquema criadorEsquema = new CriadorEsquema();
        criadorEsquema.crieEsquemaBanco();
    }

}
