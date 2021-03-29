package domain.shapes;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Point point) {
        return this.getX() == point.getX() && this.getY() == point.getY();
    }

    public int compareTo(Point point) {
        return this.getX() - point.getX();
    }

    @Override
    public String toString() {
        return String.format("(%s %s)", this.getX(), this.getY());
    }
}