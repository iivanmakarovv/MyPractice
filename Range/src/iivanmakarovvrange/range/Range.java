package iivanmakarovvrange.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "{" + from + ", " + to + "}";
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

    public Range getIntersection(Range range) {
        if (from < range.to && range.from < to) {
            return new Range(Math.max(from, range.from), Math.min(to, range.to));
        }

        return null;
    }

    public Range[] getUnion(Range range) {
        if (from <= range.to && range.from <= to) {
            return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
        }

        if (to < range.from) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }

        return new Range[]{new Range(range.from, range.to), new Range(from, to)};
    }

    public Range[] getDifference(Range range) {
        if (from < range.from && (to <= range.to && to >= range.from)) {
            return new Range[]{new Range(from, range.from)};
        }

        if ((from >= range.from && from <= range.to) && to > range.to) {
            return new Range[]{new Range(range.to, to)};
        }

        if (from < range.from && to > range.to) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        }

        if (from >= range.from && to <= range.to) {
            return new Range[]{};
        }

        return new Range[]{new Range(from, to)};
    }
}