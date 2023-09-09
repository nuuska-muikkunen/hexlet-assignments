package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }
    public double getArea() {
        return area + balconyArea;
    }
    @Override
    public String toString() {
        var totalArea = getArea();
        return "Квартира площадью " + totalArea + " метров на " + floor + " этаже";
    }
    public int compareTo(Home another) {
        if (getArea() == another.getArea()) {
            return 0;
        } else {
            return getArea() > another.getArea() ? 1 : -1;
        }
    }
}
// END
