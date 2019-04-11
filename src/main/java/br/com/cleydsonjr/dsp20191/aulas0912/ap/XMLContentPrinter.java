package br.com.cleydsonjr.dsp20191.aulas0912.ap;

import org.dom4j.DocumentException;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;

/**
 * Classe para ler o arquivo xml e imprimir na tela os seus dados
 */
public class XMLContentPrinter {

    public static void main(String[] args) {
        try {
            final URL xmlUrl = StudentsXMLContentWriter.class.getResource("/aulas0912/students.xml");
            Writer writer = new OutputStreamWriter(System.out);
            StudentsXMLContentWriter xmlContentWriter = new StudentsXMLContentWriter(writer);
            xmlContentWriter.writeStudentsData(xmlUrl);
            writer.flush();
            writer.close();
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }

}
