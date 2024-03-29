package iivanmakarovvshapes.shapes;

public class Square implements Shape {
    private double side;

    public Square(double x) {
        this.side = x;
    }

    @Override
    public String toString() {
        return "Square{" +
                "x=" + side +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Square square = (Square) o;

        return side == square.side;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(side);
        return hash;
    }

    @Override
    public double getWidth() {
        return side;
    }

    @Override
    public double getHeight() {
        return side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return side * 4;
    }
}