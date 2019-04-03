package br.com.cleydsonjr.dsp20191.aulas0912.ap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.Iterator;

class StudentsXMLContentWriter {

    private Writer writer;

    StudentsXMLContentWriter(Writer writer) {
        this.writer = writer;
    }

    void writeStudentsData(final URL inputXmlUrl) throws DocumentException, IOException {
        final Document document = readDocument(inputXmlUrl);

        final Element root = document.getRootElement();
        for (Iterator i = root.elementIterator(); i.hasNext(); ) {
            Element studentElement = (Element) i.next();
            printStudent(studentElement);

            writer.write("");
        }
    }

    private void printStudent(Element studentElement) throws IOException {
        printDivider();
        writeLine("ALUNO");
        printDivider();

        printStudentMainData(studentElement);
        Element frequenciaElement = studentElement.element("frequencia");

        for (Iterator i = frequenciaElement.elementIterator(); i.hasNext(); ) {
            Element aulasElement = (Element) i.next();
            String numero = aulasElement.attributeValue("numero");
            String presenca = aulasElement.getText();
            printData("Presença aula " + numero, presenca);
        }
    }

    private void printStudentMainData(Element studentElement) throws IOException {
        String matricula = extractChildText(studentElement, "matricula");
        String firstname = extractChildText(studentElement, "firstname");
        String lastname = extractChildText(studentElement, "lastname");
        String nickname = extractChildText(studentElement, "nickname");

        printData("Matricula", matricula);
        printData("Primeiro nome", firstname);
        printData("Ultimo nome", lastname);
        printData("Apelido", nickname);
    }

    private String extractChildText(Element studentElement, String childName) {
        Element childElement = studentElement.element(childName);
        return childElement != null ? childElement.getTextTrim() : "";
    }

    private void printData(String label, String data) throws IOException {
        writer.write(label);
        writer.write(": ");
        writeLine(data);
    }

    private void printDivider() throws IOException {
        writeLine("----------------------------------------------------------------------");
    }

    private static Document readDocument(final URL xmlUrl) throws DocumentException {
        final SAXReader reader = new SAXReader();
        return reader.read(xmlUrl);
    }

    private void writeLine(String text) throws IOException {
        writer.write(text);
        writer.write('\n');
    }

}
