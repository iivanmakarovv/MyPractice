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
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) o;

        return y == rectangle.y && x == rectangle.x;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x);
        hash = prime * hash + Double.hashCode(y);
        return hash;
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
