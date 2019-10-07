package iivanmakarovv.mypractice.rangemain;

import iivanmakarovv.mypractice.range.Range;

import static iivanmakarovv.mypractice.range.Range.*;

public class Main {
    public static void main(String[] args) {
        Range first = new Range(10, 15);
        Range second = new Range(1, 5);

        Range resultIntersection = intersection(first, second);
        Range[] resultUnion = union(first, second);
        Range[] resultDifference = difference(first, second);

        System.out.println("Пересечение:");
        try {
            System.out.println(resultIntersection.toString());
        } catch (NullPointerException e) {
            System.out.println("Пересечений нет");
        }

        System.out.println("Объединение:");
        for (Object o : resultUnion) {
            System.out.println(o.toString());
        }

        System.out.println("Разность:");
        try {
            for (Object o : resultDifference) {
                System.out.println(o.toString());
            }
        } catch (NullPointerException e) {
            System.out.println("Разности нет");
        }

    }
}
