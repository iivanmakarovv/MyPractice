package iivanmakarovv.mypractice.shapes;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {
    public int compare(Shape one, Shape two) {
        return Double.compare(one.getArea(), two.getArea());
    }
}
