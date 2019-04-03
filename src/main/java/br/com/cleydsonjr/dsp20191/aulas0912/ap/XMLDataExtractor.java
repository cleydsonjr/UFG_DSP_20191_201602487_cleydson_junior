package br.com.cleydsonjr.dsp20191.aulas0912.ap;

import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class XMLDataExtractor {

    public static void main(String[] args) {
        final URL xmlUrl = StudentsXMLContentWriter.class.getResource("/students.xml");
        final Path outputFile = Paths.get("out/output.txt");

        try {
            Files.createDirectories(outputFile.getParent());
            Writer writer = Files.newBufferedWriter(outputFile, Charset.forName("UTF-8"));
            StudentsXMLContentWriter xmlContentWriter = new StudentsXMLContentWriter(writer);
            xmlContentWriter.writeStudentsData(xmlUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
