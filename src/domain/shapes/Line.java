package domain.shapes;

import domain.exceptions.DomainException;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class Line extends Shape {

    Point start;
    Point end;

    public Line(Point start, Point end) throws DomainException {
        if (start == end) {
            throw new DomainException("Start can't be the same as the end.");
        } else if (start == null || end == null) {
            throw new DomainException("Start and end can't be null.");
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
    public String boxAround() {
        Point boxPos = new Point(min(this.getEnd().getX(), this.getEnd().getX()), min(this.getEnd().getY(), this.getEnd().getY()));
        int width = max(this.start.getX(), this.end.getX()) - boxPos.getX();
        int height = max(this.start.getY(), this.end.getY()) - boxPos.getY();
        return this.toString() + String.format("\nOmhullende: %s - %d - %d", boxPos.toString(), width, height);
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
