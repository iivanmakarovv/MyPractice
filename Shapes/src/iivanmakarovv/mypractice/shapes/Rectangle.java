package iivanmakarovv.mypractice.shapes;

public class Rectangle implements Shape {
    private double x;
    private double y;

    public Rectangle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) o;

        if (x != rectangle.x) return false;
        return y == rectangle.y;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public double getWidth() {
        return y;
    }

    @Override
    public double getHeight() {
        return x;
    }

    @Override
    public double getArea() {
        return x * y;
    }

    @Override
    public double getPerimeter() {
        return x * 2 + y * 2;
    }

}
