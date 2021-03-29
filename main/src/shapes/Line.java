package shapes;

public class Line {

    Point start;
    Point end;

    public Line(Point start, Point end) throws IllegalArgumentException {
        if (start == end) {
            throw new IllegalArgumentException("Start can't be the same as the end.");
        } else if (start == null || end == null) {
            throw new IllegalArgumentException("Start and end can't be null.");
        } else {
            this.start = start;
            this.end = end;
        }
    }

    private void setEndPoints(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return this.start;
    }

    public Point getEnd() {
        return this.end;
    }

    @Override
    public boolean equals(Object obj) {
        Point oStart = ((Line) obj).getStart();
        Point oEnd = ((Line) obj).getEnd();
        return (this.getStart() == oStart && this.getEnd() == oEnd) || (this.getStart() == oEnd && this.getEnd() == oStart);
    }

    @Override
    public String toString() {
        return String.format("Lijn: startpunt: (%s, %s) - eindpunt: (%s, %s)", this.getStart().getX(), this.getStart().getY(), this.getEnd().getX(), this.getEnd().getY());
    }
}
