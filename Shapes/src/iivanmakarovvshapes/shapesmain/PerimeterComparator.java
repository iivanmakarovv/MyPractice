package iivanmakarovvshapes.shapesmain;

import iivanmakarovvshapes.shapes.Shape;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Shape> {
    public int compare(Shape one, Shape two) {
        return Double.compare(one.getPerimeter(), two.getPerimeter());
    }
}