package br.com.cleydsonjr.dsp20191.aulas0912.ap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;

public class XMLContentPrinter {

    public static void main(String[] args) {
        final String xmlPath = "/students.xml";
        final URL xmlUrl = XMLContentPrinter.class.getResource(xmlPath);

        try {
            final Document document = readDocument(xmlUrl);

            final Element root = document.getRootElement();
            for (Iterator i = root.elementIterator(); i.hasNext(); ) {
                Element studentElement = (Element) i.next();
                printStudent(studentElement);

                System.out.println("");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private static void printStudent(Element studentElement) {
        printDivider();
        System.out.println("ALUNO");
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

    private static void printStudentMainData(Element studentElement) {
        String matricula = extractChildText(studentElement, "matricula");
        String firstname = extractChildText(studentElement, "firstname");
        String lastname = extractChildText(studentElement, "lastname");
        String nickname = extractChildText(studentElement, "nickname");

        printData("Matricula", matricula);
        printData("Primeiro nome", firstname);
        printData("Ultimo nome", lastname);
        printData("Apelido", nickname);
    }

    private static String extractChildText(Element studentElement, String childName) {
        Element childElement = studentElement.element(childName);
        return childElement != null ? childElement.getTextTrim() : "";
    }

    private static void printData(String label, String data) {
        System.out.print(label);
        System.out.print(": ");
        System.out.println(data);
    }

    private static void printDivider() {
        System.out.println("----------------------------------------------------------------------");
    }

    private static Document readDocument(final URL xmlUrl) throws DocumentException {
        final SAXReader reader = new SAXReader();
        return reader.read(xmlUrl);
    }

}
