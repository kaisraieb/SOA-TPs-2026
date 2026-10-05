import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class GenererJson {
    public static void main(String[] args) throws IOException {

        Message message = new Message();

        message.setFrom("kais");
        message.setNew(true);
        message.setText("hello");
        message.setTo("ali");

        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("json/message.json");
        file.getParentFile().mkdirs();

        mapper.writeValue(file, message);
    }
}