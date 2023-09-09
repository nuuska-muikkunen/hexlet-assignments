package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }
    public double getArea() {
        return area;
    }
    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }
    @Override
    public int compareTo(Home another) {
        if (getArea() == another.getArea()) {
            return 0;
        } else {
            return getArea() > another.getArea() ? 1 : -1;
        }
    }
}
// END
