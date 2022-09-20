package exercicio01;

public class Plano {
    private int maxX, maxY;

    public Plano(int maxX, int maxY) {
        if (maxX > 0)
            this.maxX = maxX;
        if (maxY > 0)
            this.maxY = maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }


}
