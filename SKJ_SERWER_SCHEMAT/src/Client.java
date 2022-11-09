import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {



    public static void main(String[] args) {

        String Smyk_server_ip_adress = ""; // <- insert ip
        int Smyk_server_port_adress = 0;   // <- insert port

        String first_flag = "";

        String your_ip_adress = "";
        String your_port = "";

        try {
            Socket s = new Socket(Smyk_server_ip_adress,Smyk_server_port_adress);
            PrintWriter printWriter = new PrintWriter(s.getOutputStream());
            Scanner scanner = new Scanner(s.getInputStream());

            printWriter.println(first_flag);
            printWriter.println(your_ip_adress+":"+your_port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
