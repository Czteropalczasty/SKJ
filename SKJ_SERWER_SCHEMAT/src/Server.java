import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

     final int port_id = 5050;  //deklaracja jakiego id używasz

//TODO; Obie probablyRequired nie działają, ogólnie BufferReader nie działa mi nie wiem czemu fix that


    public static void probablyRequired(BufferedReader bufferedReader,PrintWriter printWriter) throws IOException {
        //Wczytanie 1 lini od klienta i wypisanie jej
        String temp = bufferedReader.readLine();
        System.out.println(temp);
        //printWriter.println(temp);

    }

    public static void probablyRequired(Socket socket) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        //Wczytanie 1 lini od klienta i wypisanie jej
        String temp;
        temp = bufferedReader.readLine();
        System.out.println(temp);
        //printWriter.println(temp);

    }

    //Definicja wymaganych zadań funkcji, możliwe że potem dodam by otrzymywała socketa i printwritera / bufferreadera
    public static void serverFunction_1(BufferedReader bufferedReader,PrintWriter printWriter){}
    public static void serverFunction_2(BufferedReader bufferedReader,PrintWriter printWriter){}
    public static void serverFunction_3(BufferedReader bufferedReader,PrintWriter printWriter){}
    public static void serverFunction_4(BufferedReader bufferedReader,PrintWriter printWriter){}
    public static void serverFunction_5(BufferedReader bufferedReader,PrintWriter printWriter){}
    public static void serverFunction_6(BufferedReader bufferedReader,PrintWriter printWriter){}

    // In here put everything server should do
    public static void ServerFunction (Socket socket) throws IOException {}

    public static class ServerThread extends Thread {
        private final Socket socket;

        public ServerThread(Socket socket) {
            super();
            this.socket = socket;
        }

        public void run() {
            try {

                //Basic initialization
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

                printWriter.println("Hello");
                // Uncomment if required
                 probablyRequired(this.socket);


                //Functions
                serverFunction_1(bufferedReader,printWriter);
                serverFunction_2(bufferedReader,printWriter);
                serverFunction_3(bufferedReader,printWriter);
                serverFunction_4(bufferedReader,printWriter);
                serverFunction_5(bufferedReader,printWriter);
                serverFunction_6(bufferedReader,printWriter);


            } catch (Exception e1) {
                // do nothing
                System.out.println('1');
            }

            try {
                socket.close();
            } catch (IOException e) {
                // do nothing
                System.out.println('2');
            }

        }
    }

    public void listenSocket(int port){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);

        } catch (IOException e) {
            System.out.println("Could not listen");
            System.exit(-1);
        }
        System.out.println("Server listens on port: " + serverSocket.getLocalPort());
        while(true) {
            Socket client = null;
            try {
                client = serverSocket.accept();
                System.out.println("[S] connecting with:" + client.getPort());
            }
            catch (IOException e) {
                System.out.println("Accept failed");
                System.exit(-1);
            }

            (new ServerThread(client)).start();
        }

    }

    public static void main(String[] args) {
        Server server = new Server();
        server.listenSocket(server.port_id);
    }


}