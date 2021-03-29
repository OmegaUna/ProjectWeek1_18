package shapes;

import java.util.Arrays;

public class Triangle {

    private Point corner1;
    private Point corner2;
    private Point corner3;

    public Triangle(Point corner1, Point corner2, Point corner3) throws IllegalArgumentException {
        if (corner1 == corner2 || corner2 == corner3 || corner3 == corner1) {
            throw new IllegalArgumentException("Two or more corners can't be at the same position.");
        } else if (corner1 == null || corner2 == null || corner3 == null) {
            throw new IllegalArgumentException("Corner can't be null.");
        } else if (formALine(corner1, corner2, corner3)) {
            throw new IllegalArgumentException("This triangle is a line...");
        } else {
            this.corner1 = corner1;
            this.corner2 = corner2;
            this.corner3 = corner3;
            this.sortCorners();
        }
    }

    private boolean formALine(Point p1, Point p2, Point p3) {
        int x1 = p1.getX();
        int y1 = p1.getY();
        int x2 = p2.getX();
        int y2 = p2.getY();
        int x3 = p3.getX();
        int y3 = p3.getY();
        return (x2 - x1) * (y3 - y1) == (x3 - x1) * (y2 - y1);
    }

    public Point getCorner1() {
        return corner1;
    }

    private void setCorner1(Point corner1) {
        this.corner1 = corner1;
    }

    public Point getCorner2() {
        return corner2;
    }

    private void setCorner2(Point corner2) {
        this.corner2 = corner2;
    }

    public Point getCorner3() {
        return corner3;
    }

    private void setCorner3(Point corner3) {
        this.corner3 = corner3;
    }

    private void sortCorners() {
        Point[] corners = {this.getCorner1(), this.getCorner2(), this.getCorner3()};
        Arrays.sort(corners);
        this.setCorner1(corners[0]);
        this.setCorner2(corners[1]);
        this.setCorner3(corners[2]);
    }

    public boolean equals(Triangle triangle) {
        this.sortCorners();
        return this.getCorner1() == triangle.getCorner1() && this.getCorner2() == triangle.getCorner2() && this.getCorner3() == triangle.getCorner3();
    }

    @Override
    public String toString() {
        return String.format("Driehoek: hoekpunt1: %s - hoekpunt2: %s - hoekpunt3: %s", this.getCorner1().toString(), this.getCorner2().toString(), this.getCorner3().toString());
    }
}
