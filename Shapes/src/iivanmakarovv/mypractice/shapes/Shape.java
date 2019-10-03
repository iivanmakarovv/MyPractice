package iivanmakarovv.mypractice.shapes;

import java.util.Comparator;

interface Shape {
    double getWidth();

    double getHeight();

    double getArea();

    double getPerimeter();

    String getName();

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
    private String name;

    Square(double x, String name) {
        this.x = x;
        this.name = name;
    }

    public String getName() {
        return name;
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
    private String name;

    Triangle(double x1, double x2, double x3, double y1, double y2, double y3, String name) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.name = name;
    }

    public String getName() {
        return name;
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
    private String name;

    Rectangle(double x, double y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public String getName() {
        return name;
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
    private String name;

    Circle(double radius, String name) {
        this.radius = radius;
        this.name = name;
    }

    public String getName() {
        return name;
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