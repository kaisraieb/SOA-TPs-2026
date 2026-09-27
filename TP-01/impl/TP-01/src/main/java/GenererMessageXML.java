import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;

public class GenererMessageXML {

    public static void main(String[] args) throws JAXBException {
        Message message = new Message();

        message.setFrom("kais");
        message.setNew(true);
        message.setText("hello");
        message.setTo("mohamed");

        /* creation d'un context JAXB sur la classe Message */
        JAXBContext context = JAXBContext.newInstance(Message.class);

        /* creation d'un marsheller a partir de ce contexte */
        Marshaller marshaller = context.createMarshaller();

        /* on choisit UTF-8 pour encoder ce fichier */
        marshaller.setProperty("jaxb.encoding", "UTF-8");

        /* et l'on demande à JAXB de formatter ce fichier de façon à pouvoir le lire à l'oeil nu */
        // format du fichier (bien formé)
        boolean formatted = false;
        marshaller.setProperty("jaxb.formatted.output", formatted);

        /* ecriture final du document XML dans un fichier message.xml */
        marshaller.marshal(message, new File("./xml/message.xml"));

        if (formatted) {
            System.out.println("Fichier XML généré formatté");
        } else {
            System.out.println("Fichier XML généré non formatté");
        }
    }
}
