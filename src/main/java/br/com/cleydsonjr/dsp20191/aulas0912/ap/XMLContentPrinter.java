package br.com.cleydsonjr.dsp20191.aulas0912.ap;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;

public class XMLContentPrinter {

    public static void main(String[] args) {
        final URL xmlUrl = StudentsXMLContentWriter.class.getResource("/students.xml");
        Writer writer = new OutputStreamWriter(System.out);
        StudentsXMLContentWriter xmlContentWriter = new StudentsXMLContentWriter(writer);
        xmlContentWriter.writeStudentsData(xmlUrl);
    }

}
