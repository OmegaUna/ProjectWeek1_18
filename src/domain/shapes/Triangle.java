package domain.shapes;

import domain.exceptions.DomainException;

import java.util.Arrays;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class Triangle extends Vorm {

    private Punt corner1;
    private Punt corner2;
    private Punt corner3;

    public Triangle(Punt corner1, Punt corner2, Punt corner3) throws DomainException {
        if (corner1 == corner2 || corner2 == corner3 || corner3 == corner1) {
            throw new DomainException("Two or more corners can't be at the same position.");
        } else if (corner1 == null || corner2 == null || corner3 == null) {
            throw new DomainException("Corner can't be null.");
        } else if (formALine(corner1, corner2, corner3)) {
            throw new DomainException("This triangle is a line...");
        } else {
            this.corner1 = corner1;
            this.corner2 = corner2;
            this.corner3 = corner3;
            this.sortCorners();
        }
    }

    private boolean formALine(Punt p1, Punt p2, Punt p3) {
        int x1 = p1.getX();
        int y1 = p1.getY();
        int x2 = p2.getX();
        int y2 = p2.getY();
        int x3 = p3.getX();
        int y3 = p3.getY();
        return (x2 - x1) * (y3 - y1) == (x3 - x1) * (y2 - y1);
    }

    public Punt getCorner1() {
        return corner1;
    }

    private void setCorner1(Punt corner1) {
        this.corner1 = corner1;
    }

    public Punt getCorner2() {
        return corner2;
    }

    private void setCorner2(Punt corner2) {
        this.corner2 = corner2;
    }

    public Punt getCorner3() {
        return corner3;
    }

    private void setCorner3(Punt corner3) {
        this.corner3 = corner3;
    }

    private void sortCorners() {
        Punt[] corners = {this.getCorner1(), this.getCorner2(), this.getCorner3()};
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
    public Omhullende omhullende() throws DomainException {
        Punt boxPos = new Punt(min(min(this.getCorner1().getX(), this.getCorner2().getX()), this.getCorner3().getX()),
                min(min(this.getCorner1().getY(), this.getCorner2().getY()), this.getCorner3().getY()));
        int width = max(max(this.getCorner1().getX(), this.getCorner2().getX()), this.getCorner3().getX()) - boxPos.getX();
        int height = max(max(this.getCorner1().getY(), this.getCorner2().getY()), this.getCorner3().getY()) - boxPos.getY();
        return new Omhullende(boxPos, width, height);
    }

    @Override
    public String toString() {
        return String.format("Driehoek: hoekpunt1: %s - hoekpunt2: %s - hoekpunt3: %s", this.getCorner1().toString(), this.getCorner2().toString(), this.getCorner3().toString());
    }
}
