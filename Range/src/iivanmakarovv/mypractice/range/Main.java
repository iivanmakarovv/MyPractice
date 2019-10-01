package iivanmakarovv.mypractice.range;

public class Main {
    private static Range intersection(Range firstRange, Range secondRange) {
        Range rangeIntersection;

        if (firstRange.getFrom() >= secondRange.getFrom() && (firstRange.getTo() <= secondRange.getTo()
                && firstRange.getTo() >= secondRange.getFrom())) {
            rangeIntersection = new Range(firstRange.getFrom(), firstRange.getTo());

            return rangeIntersection;
        }

        if (secondRange.getFrom() >= firstRange.getFrom() && (secondRange.getTo() <= firstRange.getTo()
                && secondRange.getTo() >= firstRange.getFrom())) {
            rangeIntersection = new Range(secondRange.getFrom(), secondRange.getTo());

            return rangeIntersection;
        }

        if (firstRange.getFrom() <= secondRange.getFrom() && firstRange.getTo() >= secondRange.getFrom()) {
            rangeIntersection = new Range(secondRange.getFrom(), firstRange.getTo());

            return rangeIntersection;
        }

        if (secondRange.getFrom() <= firstRange.getFrom() && secondRange.getTo() >= firstRange.getFrom()) {
            rangeIntersection = new Range(firstRange.getFrom(), secondRange.getTo());

            return rangeIntersection;
        }
        rangeIntersection = null;

        return rangeIntersection;
    }

    private static Range[] union(Range firstRange, Range secondRange) {
        Range[] unionRange;

        if (firstRange.getFrom() <= secondRange.getFrom() &&
                (firstRange.getTo() <= secondRange.getTo() && secondRange.getFrom() <= firstRange.getTo())) {
            unionRange = new Range[1];
            unionRange[0] = new Range(firstRange.getFrom(), secondRange.getTo());

            return unionRange;
        }

        if (secondRange.getFrom() <= firstRange.getFrom() &&
                (secondRange.getTo() <= firstRange.getTo() && firstRange.getFrom() <= secondRange.getTo())) {
            unionRange = new Range[1];
            unionRange[0] = new Range(secondRange.getFrom(), firstRange.getTo());

            return unionRange;
        }

        if (firstRange.getTo() < secondRange.getFrom()) {
            unionRange = new Range[2];
            unionRange[0] = new Range(firstRange.getFrom(), firstRange.getTo());
            unionRange[1] = new Range(secondRange.getFrom(), secondRange.getTo());

            return unionRange;
        }

        unionRange = new Range[2];
        unionRange[1] = new Range(firstRange.getFrom(), firstRange.getTo());
        unionRange[0] = new Range(secondRange.getFrom(), secondRange.getTo());

        return unionRange;
    }

    private static Range[] difference(Range firstRange, Range secondRange) {
        Range[] differenceRange;

        if(firstRange.getFrom() < secondRange.getFrom() &&
                (firstRange.getTo() <= secondRange.getTo() && firstRange.getTo() >= secondRange.getFrom())){
            differenceRange = new Range[1];
            differenceRange[0] = new Range(firstRange.getFrom(), secondRange.getFrom());

            return differenceRange;
        }

        if((firstRange.getFrom() >= secondRange.getFrom() && firstRange.getFrom() <= secondRange.getTo()) &&
                firstRange.getTo() > secondRange.getTo()){
            differenceRange = new Range[1];
            differenceRange[0] = new Range(secondRange.getTo(), firstRange.getTo());

            return differenceRange;
        }

        if(firstRange.getFrom() < secondRange.getFrom() && firstRange.getTo() > secondRange.getTo()){
            differenceRange = new Range[2];
            differenceRange[0] = new Range(firstRange.getFrom(), secondRange.getFrom());
            differenceRange[1] = new Range(secondRange.getTo(), firstRange.getTo());

            return differenceRange;
        }

        differenceRange = new Range[1];
        differenceRange[0] = new Range(0, 0);

        return differenceRange;
    }

    public static void main(String[] args) {
        Range firstRange = new Range(1, 100);
        Range secondRange = new Range(50, 150);
        Range resultRange = intersection(firstRange, secondRange);
        Range[] resultUnionRange = union(firstRange, secondRange);
        Range[] resultDifferenceRange = difference(firstRange,secondRange);

        //System.out.println(resultRange.getFrom());
        //System.out.println(resultRange.getTo());

        //System.out.println(resultUnionRange[0].getFrom());
        //System.out.println(resultUnionRange[0].getTo());

        //System.out.println(resultUnionRange[1].getFrom());
        //System.out.println(resultUnionRange[1].getTo());

        //System.out.println(resultDifferenceRange[0].getFrom());
        //System.out.println(resultDifferenceRange[0].getTo());

        //System.out.println(resultDifferenceRange[1].getFrom());
        //System.out.println(resultDifferenceRange[1].getTo());
    }
}
