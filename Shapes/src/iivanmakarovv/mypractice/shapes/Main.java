package iivanmakarovv.mypractice.shapes;

import java.util.Arrays;

public class Main {

    private static String printFirstAreaShape(Shape[] shapeArray){
        Arrays.sort(shapeArray,Shape.AreaComparator);
        return shapeArray[6].getName();
    }

    private static String printSecondPerimeterShape(Shape[] shapeArray){
        Arrays.sort(shapeArray,Shape.PerimeterComparator);
        return shapeArray[5].getName();
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

        System.out.println("Первую по величине площадь имеет фигура " + printFirstAreaShape(shapeArray));
        System.out.println("Второй по величине периметр имеет фигура " + printSecondPerimeterShape(shapeArray));
    }
}

