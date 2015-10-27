package spaceship;

/**
 *
 * @author andrea
 */
class SpaceShip {

    private int myX; // posicao X da espaconave
    private int myY; // posicao Y da espaconave
    private int myColor; // cor da espaconave
    private int myXmax; // posicao limite X da espaconave
    private int myYmax; // posicao limite Y da espaconave
    private static final int defaultXmax = 600; // limite X, valor constante
    private static final int defaultYmax = 300; // limite Y, valor constante
    public static final int defaultColor = 0xfffb7df4; // pink
    public String myName;

    public SpaceShip(int x, int y) {
        myX = x;
        myY = y;
        myColor = defaultColor;
        myXmax = defaultXmax;
        myYmax = defaultYmax;
        myName = "Enterprise";
    }

    public int getX() {
        return myX;
    }

    public int getY() {
        return myY;
    }

    public int getColor() {
        return myColor;
    }

    public void setColor(int color) {
        myColor = color;
    }

    public void setLimits(int xmax, int ymax) {
        myXmax = xmax;
        myYmax = ymax;
    }

    public int getXmax() {
        return myXmax;
    }

    public int getYmax() {
        return myYmax;
    }

    public void move() {
        myX++;
        myY++;
    }

    public void print() {
        System.out.printf("Spaceship at (%d,%d), color: %x, name: %s\n", myX, myY, myColor, myName);
    }

}

class SpaceShipTest {

    public static void main(String[] args) {
        SpaceShip sr;
        SpaceShip ship = new SpaceShip(20, 20);
        ship.print();
        ship.move();
        ship.print();
        ship.setColor(0xffff0000);
        ship.print();
    }
}
