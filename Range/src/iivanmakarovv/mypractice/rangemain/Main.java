package iivanmakarovv.mypractice.rangemain;

import iivanmakarovv.mypractice.range.Range;
import static iivanmakarovv.mypractice.range.Range.*;

public class Main {
    public static void main(String[] args) {
        Range first = new Range(1, 50);
        Range second = new Range(50, 150);

        Range resultIntersection = intersection(first, second);
        Range[] resultUnion = union(first, second);
        Range[] resultDifference = difference(first, second);

        System.out.println(resultIntersection.toString());

        /*for (Object o : resultUnion) {
            System.out.println(o.toString());
        }*/

        /*for (Object o : resultDifference) {
            System.out.println(o.toString());
        }*/
    }
}
