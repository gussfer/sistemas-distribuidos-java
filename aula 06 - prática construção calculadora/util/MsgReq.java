//Classe responsável por enviar req para o servidor
package util;

import java.io.Serializable;

public class MsgReq implements Serializable {
    private double value1, value2;
    private char oper;


    public MsgReq(double value1, double value2, char oper) {
        this.value1 = value1;
        this.value2 = value2;
        this.oper = oper;
    } 

    public char getOper() {
        return oper;
    }

    public double getValue1() {
        return value1;
    }

    public double getValue2() {
        return value2;
    }


}
