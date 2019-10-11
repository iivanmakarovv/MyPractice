package iivanmakarovv.mypractice.rangemain;

import iivanmakarovv.mypractice.range.Range;

public class Main {
    public static void main(String[] args) {
        Range first = new Range(5, 10);
        Range second = new Range(1, 15);

        Range resultIntersection = first.getIntersection(second);
        Range[] resultUnion = first.getUnion(second);
        Range[] resultDifference = first.getDifference(second);

        System.out.println("Пересечение:");
        if (resultIntersection != null) {
            System.out.println(resultIntersection);
        } else {
            System.out.println("Пересечений нет");
        }

        System.out.println("Объединение:");
        for (Range range : resultUnion) {
            System.out.println(range);
        }

        System.out.println("Разность:");
            for (Range range : resultDifference) {
                System.out.println(range);
            }
    }
}