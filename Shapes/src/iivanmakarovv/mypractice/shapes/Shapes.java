package iivanmakarovv.mypractice.shapes;

interface Shapes {
    double getWidth();

    double getHeight();

    double getArea();

    double getPerimeter();
}

class Square implements Shapes {
    private double x;

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

class Triangle implements Shapes {
    private double x1;
    private double x2;
    private double x3;
    private double y1;
    private double y2;
    private double y3;

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

class Rectangle implements Shapes {
    private double x;
    private double y;

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

class Circle implements Shapes {
    private double radius;

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