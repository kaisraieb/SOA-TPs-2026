import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class FromXmlToJavaObject {
    /*
     * Unmarshalling
     * */

    public static void main(String[] args) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(Message.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        Message message = (Message) unmarshaller.unmarshal(new File("./xml/message.xml"));

        System.out.println("Deserialisation avec succés !");

        System.out.println("From : " + message.getFrom());
        System.out.println("To   : " + message.getTo());
        System.out.println("Text : " + message.getText());
    }
}
