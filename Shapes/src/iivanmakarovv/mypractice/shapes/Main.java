package iivanmakarovv.mypractice.shapes;

import java.util.Arrays;

public class Main {

    private static void printFirstAreaShape(Shape[] shapeArray){
        Arrays.sort(shapeArray,Shape.AreaComparator);
        System.out.println("Первую по величине площадь имеет фигура " + shapeArray[6].getName());
    }

    private static void printSecondPerimeterShape(Shape[] shapeArray){
        Arrays.sort(shapeArray,Shape.PerimeterComparator);
        System.out.println("Второй по величине периметр имеет фигура " + shapeArray[5].getName());
    }

    public static void main(String[] args) {

        Shape[] shapeArray = new Shape[7];

        shapeArray[0] = new Square(4, "Square1");
        shapeArray[1] = new Rectangle(4, 8,"Rectangle1");
        shapeArray[2] = new Triangle(0, 0, 4, 0, 4, 4,"Triangle1");
        shapeArray[3] = new Circle(3,"Circle1");
        shapeArray[4] = new Square(5,"Square2");
        shapeArray[5] = new Rectangle(2, 8,"Rectangle2");
        shapeArray[6] = new Circle(1,"Circle2");

        printFirstAreaShape(shapeArray);
        printSecondPerimeterShape(shapeArray);
    }
}

