package iivanmakarovv.mypractice.shapes;

public class Square implements Shape {
    private double x;

    public Square(double x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Square{" +
                "x=" + x +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Square square = (Square) o;

        return x == square.x;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(x);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public double getWidth() {
        return x;
    }

    @Override
    public double getHeight() {
        return x;
    }

    @Override
    public double getArea() {
        return x * x;
    }

    @Override
    public double getPerimeter() {
        return x * 4;
    }
}
