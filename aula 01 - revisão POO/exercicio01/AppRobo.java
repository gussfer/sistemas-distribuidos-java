package exercicio01;

public class AppRobo {
    public static void main(String[] args) {
        RoboSimples robo = new RoboSimples(50, 50);

        System.out.println(robo);

        robo.deslocar(Direcao.SUL, 5);
        robo.deslocar(Direcao.OESTE, 3);

        System.out.println(robo);
    }

}


