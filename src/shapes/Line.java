package shapes;

public class Line extends Shape {

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

    public boolean equals(Line line) {
        Point oStart = line.getStart();
        Point oEnd = line.getEnd();
        return (this.getStart() == oStart && this.getEnd() == oEnd) || (this.getStart() == oEnd && this.getEnd() == oStart);
    }

    @Override
    public void draw() {
        ; //TODO
    }

    @Override
    public String toString() {
        return String.format("Lijn: startpunt: %s - eindpunt: %s", this.getStart().toString(), this.getEnd().toString());
    }
}
