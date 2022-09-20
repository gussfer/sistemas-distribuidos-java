package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import util.MsgReq;
import util.MsgResp;
import util.Status;

public class Calcule extends Thread {
    private Socket socketClient;

    public Calcule(Socket socketClient) {
        this.socketClient = socketClient;
    }

    @Override
    public void run() {
        ObjectOutputStream out;
        ObjectInputStream in;
        try {
            out = new ObjectOutputStream(socketClient.getOutputStream());
            in = new ObjectInputStream(socketClient.getInputStream());

            MsgReq msgReq = (MsgReq) in.readObject();

            System.out.println("Recebido: ");
            System.out.println(msgReq.getValue1() +
                    " " + msgReq.getOper() +
                    " " + msgReq.getValue2());
            double n1 = msgReq.getValue1();
            double n2 = msgReq.getValue2();
            char oper = msgReq.getOper();
            
            // MsgResp msgResp = new MsgResp(1, 5);
            MsgResp msgResp;
            switch (oper) {
                case '+':
                    msgResp = new MsgResp(Status.SUCESSO, n1 + n2);
                    break;
                case '-':
                    msgResp = new MsgResp(Status.SUCESSO, n1 - n2);
                    break;
                case '*':
                    msgResp = new MsgResp(Status.SUCESSO, n1 * n2);
                    break;
                case '/':
                    if (n2 == 0) {
                        msgResp = new MsgResp(Status.ERRO_DIVISAO, 0);
                    } else {
                        msgResp = new MsgResp(Status.SUCESSO, n1 / n2);
                    }
                    break;
                default:
                    msgResp = new MsgResp(Status.ERRO_OPERADOR, 0);
            }
            
            out.writeObject(msgResp);
            socketClient.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
