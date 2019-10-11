package iivanmakarovv.mypractice.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "{from=" + from + ", to=" + to + "}";
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

    public Range getIntersection(Range second) {
        if (this.from < second.to && second.from < this.to) {
            return new Range(Math.max(this.from, second.from), Math.min(this.to, second.to));
        }

        return null;
    }

    public Range[] getUnion(Range second) {
        if (this.from <= second.to && second.from <= this.to) {
            return new Range[]{new Range(Math.min(this.from, second.from), Math.max(this.to, second.to))};
        }

        if (this.to < second.from) {
            return new Range[]{new Range(this.from, this.to), new Range(second.from, second.to)};
        }

        return new Range[]{new Range(second.from, second.to), new Range(this.from, this.to)};
    }

    public Range[] getDifference(Range second) {
        if (this.from < second.from && (this.to <= second.to && this.to >= second.from)) {
            return new Range[]{new Range(this.from, second.from)};
        }

        if ((this.from >= second.from && this.from <= second.to) && this.to > second.to) {
            return new Range[]{new Range(second.to, this.to)};
        }

        if (this.from < second.from && this.to > second.to) {
            return new Range[]{new Range(this.from, second.from), new Range(second.to, this.to)};
        }

        if (this.from >= second.from && this.to <= second.to) {
            return new Range[]{};
        }

        return new Range[]{new Range(this.from, this.to)};
    }
}