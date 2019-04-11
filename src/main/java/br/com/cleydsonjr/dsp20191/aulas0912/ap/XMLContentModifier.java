package br.com.cleydsonjr.dsp20191.aulas0912.ap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * Classe para ler o arquivo xml e alterar o valor da sua frequência na aula de número “0104”
 */
public class XMLContentModifier {

    public static void main(String[] args) {
        final URL xmlUrl = XMLContentModifier.class.getResource("/aulas0912/students.xml");
        final Path outputFile = Paths.get("out/output.xml");
        try {
            final Document document = readDocument(xmlUrl);

            final Element root = document.getRootElement();
            for (Iterator i = root.elementIterator(); i.hasNext(); ) {
                Element studentElement = (Element) i.next();

                String matricula = extractChildText(studentElement, "matricula");
                if (matricula.equals("201602487")) {
                    Element frequenciaElement = studentElement.element("frequencia");

                    for (Iterator i1 = frequenciaElement.elementIterator(); i1.hasNext(); ) {
                        Element aulasElement = (Element) i1.next();
                        String numero = aulasElement.attributeValue("numero");

                        if (numero.equals("0104")) {
                            aulasElement.setText("P");
                        }
                    }
                }
            }
            Files.createDirectories(outputFile.getParent());
            Writer writer = Files.newBufferedWriter(outputFile, Charset.forName("UTF-8"));
            document.write(writer);
            writer.flush();
            writer.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    private static String extractChildText(Element studentElement, String childName) {
        Element childElement = studentElement.element(childName);
        return childElement != null ? childElement.getTextTrim() : "";
    }

    private static Document readDocument(final URL xmlUrl) throws DocumentException {
        final SAXReader reader = new SAXReader();
        return reader.read(xmlUrl);
    }
}
