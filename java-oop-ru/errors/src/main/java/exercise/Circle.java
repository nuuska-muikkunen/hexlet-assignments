package exercise;

// BEGIN
public class Circle {
    private int radius;
    private Point dot;

    public Circle(Point dot, int radius) {
        this.radius = radius;
        this.dot = dot;
    }
    public int getRadius() {
        return radius;
    }
    public double getSquare() throws NegativeRadiusException {
        if (radius < 0 ) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
        return radius * radius * Math.PI;
    }
}
// END
