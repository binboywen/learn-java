import java.io.*;
import java.util.Properties;

public class javaProperties {
    public static void main(String [] args) throws IOException {
        Properties prop = new Properties();
        prop.setProperty("Hey","Em");
        prop.setProperty("HeyGirl","EmGirl");
        prop.store(new FileOutputStream(new File("E:" +
                File.separator + "test" + File.separator + "info.properties")),
                "中文的注释看不见的");
        prop.load(new FileInputStream(new File("E:" +
                File.separator + "test" + File.separator + "info.properties")));
        System.out.println(prop.getProperty("Hey"));
    }
}
