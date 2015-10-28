package circle;

class Circle extends Ponto {

    private Ponto centro;
    private double raio;

    public Circle() {
        centro = new Ponto(10.0, 10.0);
        this.raio = 2.0;
    }

    public Circle(double x, double y, double raio) {
        centro = new Ponto(x, y);
        this.raio = raio;
    }

    public double getArea() {
        return Math.PI * (raio * raio);
    }

    public double getDiameter() {
        return 2 * raio;
    }
    
    public static void main(String[] args){
        Circle circulo1 = new Circle(13, 22, 3);
        Circle circulo2 = new Circle(5, 14, 5);
        
        System.out.printf("Área do círculo 1: %.2f\n", circulo1.getArea());
        System.out.printf("Área do círculo 2: %.2f\n", circulo2.getArea());
        System.out.printf("Diâmetro do círculo 1: %.2f\n", circulo1.getDiameter());
        System.out.printf("Diâmetro do círculo 2: %.2f\n", circulo2.getDiameter());
        System.out.printf("Distância entre c1 e c2: %.2f\n", circulo1.centro.distance(circulo2.centro));   
    }
}
