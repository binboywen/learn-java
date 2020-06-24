import com.sun.security.ntlm.Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class JavaEchoClient {
    private static final BufferedReader KEYBOARD_INPUT = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String [] args) throws Exception{
        Socket client = new Socket("localhost",9999);
        Scanner scanner = new Scanner((client.getInputStream()));
        scanner.useDelimiter("\n");
        PrintStream out = new PrintStream(client.getOutputStream());
        boolean flag = true;
        while(flag){
            String input = getString("请输入要发送的内容").trim();
            out.println(input);

            if(scanner.hasNext()){
                System.out.println(scanner.next());
            }
            if("exit".equalsIgnoreCase(input)){
                 flag = false;
            }
        }
        scanner.close();
        out.close();
        client.close();
    }
    public static String getString(String prompt) throws Exception{
        System.out.println(prompt);
        String str = KEYBOARD_INPUT.readLine();
        return str;
    }

}
