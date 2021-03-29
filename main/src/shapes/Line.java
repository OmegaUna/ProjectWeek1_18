package shapes;

import java.awt.*;

public class Line {

    Point start;
    Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
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
        return String.format("Lijn: startpunt: (%s, %s) - eindpunt: (%s, %s)", this.getStart().x, this.getStart().y, this.getEnd().x, this.getEnd().y);
    }
}
