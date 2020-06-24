import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class MathDemo {
    public static void main(String [] args){
        double a = Math.ulp(1000000);
        System.out.println(a);
        Date date = new Date();
        Locale loc = new Locale("en","US");
        ResourceBundle resource = ResourceBundle.getBundle("Message",loc);
        String val = resource.getString("info");
        System.out.println(MessageFormat.format(val,"mldn",new SimpleDateFormat("yyyy-MM-dd").format(new Date())));

    }
}



