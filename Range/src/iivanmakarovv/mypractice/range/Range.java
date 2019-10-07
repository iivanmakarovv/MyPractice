package iivanmakarovv.mypractice.range;

public class Range {
    private double from;
    private double to;

    @Override
    public String toString() {
        return "{" + "from=" + from + ", to=" + to + '}';
    }

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double x) {
        return x >= from && x <= to;
    }

    public static Range intersection(Range first, Range second) {
        if (first.from < second.to && second.from < first.to) {
            return new Range(Math.max(first.from, second.from), Math.min(first.to, second.to));
        }

        return null;
    }

    public static Range[] union(Range first, Range second) {
        if (first.from <= second.to && second.from <= first.to) {
            return new Range[]{new Range(Math.min(first.from, second.from), Math.max(first.to, second.to))};
        }

        if (first.to < second.from) {
            return new Range[]{new Range(first.from, first.to), new Range(second.from, second.to)};
        }

        return new Range[]{new Range(second.from, second.to), new Range(first.from, first.to)};
    }

    public static Range[] difference(Range first, Range second) {
        if (first.from < second.from && (first.to <= second.to && first.to >= second.from)) {
            return new Range[]{new Range(first.from, second.from)};
        }

        if ((first.from >= second.from && first.from <= second.to) && first.to > second.to) {
            return new Range[]{new Range(second.to, first.to)};
        }

        if (first.from < second.from && first.to > second.to) {
            return new Range[]{new Range(first.from, second.from), new Range(second.to, first.to)};
        }

        if (first.from >= second.from && first.to <= second.to) {
            return null;
        }

        return new Range[]{new Range(first.from, first.to)};
    }
}

