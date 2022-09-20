package exercicio01;

/**
 * RoboSimples
 */
public class RoboSimples extends Object {
    private int x, y;
    private Plano plano;

    public RoboSimples(int maxX, int maxY) {
        this(0, 0, maxX, maxY); // chamada ao construtor
    }

    public RoboSimples(int x, int y, int maxX, int maxY) {
        plano = new Plano(maxX, maxY);
        if (x >= 0)
            this.x = x;
        if (y >= 0)
            this.y = y;
    }

    public void deslocar(Direcao direcao, int deslocamento) {
        switch (direcao) {
            case SUL:
                if (y + deslocamento < plano.getMaxY())
                    y += deslocamento;
                break;
            case NORTE:
                if (y - deslocamento > 0)
                    y -= deslocamento;
                break;
            case LESTE:
                if (x + deslocamento < plano.getMaxX())
                    x += deslocamento;
                break;
            case OESTE:
                if (x - deslocamento > 0)
                    x -= deslocamento;
                break;
        }
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

}
