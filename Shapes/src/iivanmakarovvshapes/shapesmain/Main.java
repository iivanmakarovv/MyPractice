package iivanmakarovvshapes.shapesmain;

import iivanmakarovv.mypractice.shapes.*;
import iivanmakarovvmatrix.shapes.*;
import iivanmakarovvshapes.shapes.*;

import java.util.Arrays;

public class Main {
    private static String getFirstAreaShape(Shape[] shapeArray) {
        Arrays.sort(shapeArray, new AreaComparator());
        return shapeArray[shapeArray.length - 1].toString();
    }

    private static String getSecondPerimeterShape(Shape[] shapeArray) {
        Arrays.sort(shapeArray, new PerimeterComparator());
        return shapeArray[shapeArray.length - 2].toString();
    }

    public static void main(String[] args) {
        Shape[] shapeArray = new Shape[]{new Square(4), new Rectangle(4, 8),
                new Triangle(0, 0, 4, 0, 4, 4),
                new Circle(3), new Square(5), new Rectangle(2, 8),
                new Circle(1)};

        System.out.println("Первую по величине площадь имеет фигура " + getFirstAreaShape(shapeArray));
        System.out.println("Второй по величине периметр имеет фигура " + getSecondPerimeterShape(shapeArray));
    }
}