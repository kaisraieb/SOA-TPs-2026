package dev.kais.Utils;

import java.io.InputStream;
import java.net.URI;
import java.nio.file.Path;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class WsdlDownload {

    public static void download(String url, Path destination) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        try (InputStream in = URI.create(url).toURL().openStream()) {
            transformer.transform(new StreamSource(in), new StreamResult(destination.toFile()));
        }
        System.out.println("fichier enregistrer : " + destination.toAbsolutePath());
    }

    public static void main(String[] args) {
        String base = "http://localhost:9000/BanqueWS";
        try {
            download(base + "?wsdl", Path.of("./wsdl/BanqueService.wsdl"));
            download(base + "?xsd=1", Path.of("./xsd/BanqueService.xsd"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
