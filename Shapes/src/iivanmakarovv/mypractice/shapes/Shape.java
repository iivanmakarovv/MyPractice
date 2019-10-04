package iivanmakarovv.mypractice.shapes;

import java.util.Comparator;

interface Shape {
    double getWidth();

    double getHeight();

    double getArea();

    double getPerimeter();

    Comparator<Shape> AreaComparator = new Comparator<Shape>() {
        @Override
        public int compare(Shape one, Shape two) {
            return (int) (one.getArea() - two.getArea());
        }
    };

    Comparator<Shape> PerimeterComparator = new Comparator<Shape>() {
        @Override
        public int compare(Shape one, Shape two) {
            return (int) (one.getPerimeter() - two.getPerimeter());
        }
    };
}

class Square implements Shape {
    private double x;

    @Override
    public String toString() {
        return "Square{" +
                "x=" + x +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return x == square.x;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(x);
        return (int) (temp ^ (temp >>> 32));
    }

    Square(double x) {
        this.x = x;
    }

    public double getWidth() {
        return x;
    }

    public double getHeight() {
        return x;
    }

    public double getArea() {
        return x * x;
    }

    public double getPerimeter() {
        return x * 4;
    }
}

class Triangle implements Shape {
    private double x1;
    private double x2;
    private double x3;
    private double y1;
    private double y2;
    private double y3;

    @Override
    public String toString() {
        return "Triangle{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                ", x3=" + x3 +
                ", y1=" + y1 +
                ", y2=" + y2 +
                ", y3=" + y3 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (x1 != triangle.x1) return false;
        if (x2 != triangle.x2) return false;
        if (x3 != triangle.x3) return false;
        if (y1 != triangle.y1) return false;
        if (y2 != triangle.y2) return false;
        return y3 == triangle.y3;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x1);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(x2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(x3);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y1);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y3);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    Triangle(double x1, double x2, double x3, double y1, double y2, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    private double getSideA() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private double getSideB() {
        return Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
    }

    private double getSideC() {
        return Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
    }

    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    public double getArea() {
        return Math.sqrt((getPerimeter() / 2) * (getPerimeter() / 2 - getSideA()) *
                (getPerimeter() / 2 - getSideB()) * (getPerimeter() / 2 - getSideC()));
    }

    public double getPerimeter() {
        return getSideA() + getSideB() + getSideC();
    }
}

class Rectangle implements Shape {
    private double x;
    private double y;

    @Override
    public String toString() {
        return "Rectangle{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

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

    Rectangle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getWidth() {
        return y;
    }

    public double getHeight() {
        return x;
    }

    public double getArea() {
        return x * y;
    }

    public double getPerimeter() {
        return x * 2 + y * 2;
    }

}

class Circle implements Shape {
    private double radius;

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(radius);
        return (int) (temp ^ (temp >>> 32));
    }

    Circle(double radius) {
        this.radius = radius;
    }

    public double getWidth() {
        return radius * 2;
    }

    public double getHeight() {
        return radius * 2;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return Math.PI * (radius * 2);
    }

}