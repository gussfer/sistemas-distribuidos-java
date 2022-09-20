package server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        final int PORT = 9876;
        ServerSocket srvSocket;
        Socket socketCli;
        

        try {
            srvSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("Aguardando o cliente...");
                socketCli = srvSocket.accept(); // conecta o cliente
    
                Calcule calcule = new Calcule(socketCli);
                calcule.start();
            }
            // srvSocket.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
