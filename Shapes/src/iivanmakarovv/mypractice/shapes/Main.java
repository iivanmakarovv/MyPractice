package iivanmakarovv.mypractice.shapes;

import java.util.Arrays;

public class Main {

    private static String printFirstAreaShape(Shape[] shapeArray){
        Arrays.sort(shapeArray,Shape.AreaComparator);
        return shapeArray[6].toString();
    }

    private static String printSecondPerimeterShape(Shape[] shapeArray){
        Arrays.sort(shapeArray,Shape.PerimeterComparator);
        return shapeArray[5].toString();
    }

    public static void main(String[] args) {
        Shape[] shapeArray = new Shape[7];

        shapeArray[0] = new Square(4);
        shapeArray[1] = new Rectangle(4, 8);
        shapeArray[2] = new Triangle(0, 0, 4, 0, 4, 4);
        shapeArray[3] = new Circle(3);
        shapeArray[4] = new Square(5);
        shapeArray[5] = new Rectangle(2, 8);
        shapeArray[6] = new Circle(1);

        System.out.println("Первую по величине площадь имеет фигура " + printFirstAreaShape(shapeArray));
        System.out.println("Второй по величине периметр имеет фигура " + printSecondPerimeterShape(shapeArray));

    }
}

