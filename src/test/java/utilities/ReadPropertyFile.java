package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("C:\\Users\\admin\\IdeaProjects\\automationTestFrameworkMaven\\src\\test\\java\\config\\config.properties");
        Properties p = new Properties();
        p.load(fr);
        System.out.println(p.getProperty("browser"));
        System.out.println(p.getProperty("testurl"));
    }
}
