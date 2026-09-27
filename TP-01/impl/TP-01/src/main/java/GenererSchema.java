import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.SchemaOutputResolver;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class GenererSchema {

    public static void main(String[] args) throws Exception {

        JAXBContext context = JAXBContext.newInstance(Message.class);

        context.generateSchema(new SchemaOutputResolver() {

            @Override
            public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {

                File file = new File("./xsd/message.xsd");

                StreamResult result = new StreamResult(file);

                result.setSystemId(file.toURI().toURL().toString());

                return result;
            }
        });

        System.out.println("Schema généré avec succès : message.xsd");
    }
}
