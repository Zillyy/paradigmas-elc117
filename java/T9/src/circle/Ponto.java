package circle;

class Ponto {

    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public Ponto(){
        x = 0.0;
        y = 0.0;
    }

    public Ponto(double X, double Y) {
        x = X;
        y = Y;
    }

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public double distance(Ponto p1) {
        double dx = p1.x - x;
        double dy = p1.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

}
