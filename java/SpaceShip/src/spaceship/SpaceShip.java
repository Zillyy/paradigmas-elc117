package spaceship;

/**
 *
 * @author andrea
 */
class SpaceShip {

    private float myX; // posicao X da espaconave
    private float myY; // posicao Y da espaconave
    private int myColor; // cor da espaconave
    private int myXmax; // posicao limite X da espaconave
    private int myYmax; // posicao limite Y da espaconave
    private float speedX; //velocidade em X
    private float speedY; //velocidade em Y
    private static final int defaultXmax = 400; // limite X, valor constante
    private static final int defaultYmax = 400; // limite Y, valor constante
    public static final int defaultColor = 0xfffb7df4; // pink
    public String myName;

    public SpaceShip(int x, int y) {
        myX = x;
        myY = y;
        myColor = defaultColor;
        myXmax = defaultXmax;
        myYmax = defaultYmax;
        myName = "Enterprise";
        speedX = (float) 1.2;
        speedY = (float) 1.5;
    }

    public float getX() {
        return myX;
    }

    public float getY() {
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

    public void moveCollision() {
        if(myX > myXmax) {if(speedX > 0) speedX *= -1;}
        if(myY > myYmax) {if(speedY > 0) speedY *= -1;}
        if(myX < 0) {if(speedX < 0) speedX *= -1;}
        if(myY < 0) {if(speedY < 0) speedY *= -1;}
        
        
        move(speedX, speedY);
    }

    public void move(float incX, float incY) {
        myX += incX;
        myY += incY;
    }

    public void print() {
        System.out.printf("Spaceship at (%g,%g), color: %x, name: %s\n", myX, myY, myColor, myName);
    }

}

/*class SpaceShipTest {

 public static void main(String[] args) {
 SpaceShip ship2 = new SpaceShip(100, 100);
 //SpaceShip ship = new SpaceShip(20, 20);
 //ship.print();
 ship2.print();
 //ship.move();
 ship2.move();
 //ship.print();
 ship2.print();
 //ship.setColor(0xffff0000);
 ship2.setColor(0xffff0000);
 //ship.print();
 ship2.print();
 }
 }*/
