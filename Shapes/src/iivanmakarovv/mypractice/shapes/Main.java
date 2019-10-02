package iivanmakarovv.mypractice.shapes;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shapes[] shapesArray = new Shapes[7];

        shapesArray[0] = new Square(4);
        shapesArray[1] = new Rectangle(4, 8);
        shapesArray[2] = new Triangle(0, 0, 4, 0, 4, 4);
        shapesArray[3] = new Circle(3);
        shapesArray[4] = new Square(5);
        shapesArray[5] = new Rectangle(3, 9);
        shapesArray[6] = new Circle(1);

        for (int i = 0; i < 7; ++i) {
            System.out.println(shapesArray[i].getArea());
        }
    }
}
