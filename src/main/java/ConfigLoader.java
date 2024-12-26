import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    public static void main(String[] args) {
        Properties props = new Properties();
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Файл config.properties не найден.");
                return;
            }
            props.load(input);
            System.out.println("props.local.hello: " + props.getProperty("props.local.hello"));
            System.out.println("props.mvn.hello: " + props.getProperty("props.mvn.hello"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}