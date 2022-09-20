package cliente;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import util.MsgReq;
import util.MsgResp;
import util.Status;

public class Cliente {
    public static void main(String[] args) {
        final String IP = "127.0.0.1"; // localhost
        final int PORT = 9876;
        Socket socket;
        double number1;
        double number2;
        char operation;
        ObjectOutputStream out;
        ObjectInputStream in;
        Scanner entrada = new Scanner(System.in);

        try {
            socket = new Socket(IP, PORT);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            System.out.println("Qual a operação (+ - * /)? ");
            operation = entrada.nextLine().charAt(0);
            System.out.println("Informe o primeiro valor:");
            number1 = entrada.nextDouble();
            System.out.println("Informe o segundo valor:");
            number2 = entrada.nextDouble();

            MsgReq msgReq = new MsgReq(number1, number2, operation);

            out.writeObject(msgReq);

            MsgResp msgResp = (MsgResp) in.readObject();

            if (msgResp.getStatus() == Status.SUCESSO) {
                System.out.println("Resposta: " + msgResp.getValue());
            } else {
                if (msgResp.getStatus() == Status.ERRO_DIVISAO) {
                    System.out.println("Não é possível dividir por zero");
                } else {
                    System.out.println("Operador inválido.");
                }
            }

            socket.close();
            entrada.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
