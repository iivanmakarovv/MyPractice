package iivanmakarovvrange.rangemain;

import iivanmakarovvrange.range.Range;

public class Main {
    public static void main(String[] args) {
        Range first = new Range(5, 10);
        Range second = new Range(1, 20);

        Range intersectionResult = first.getIntersection(second);
        Range[] unionResult = first.getUnion(second);
        Range[] differenceResult = first.getDifference(second);

        System.out.print("Пересечение:");
        if (intersectionResult != null) {
            System.out.print(intersectionResult);
        } else {
            System.out.print("Пересечений нет");
        }
        System.out.println();

        System.out.print("Объединение:");
        System.out.print("[]");
        for (Range range : unionResult) {
            System.out.print(range);
        }
        System.out.println();

        System.out.print("Разность:");
        System.out.print("[]");
        for (Range range : differenceResult) {
            System.out.print(range);
        }
        System.out.println();
    }
}