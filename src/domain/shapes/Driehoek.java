package domain.shapes;

import domain.exceptions.DomainException;

import java.util.Arrays;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class Driehoek extends Vorm {

    private Punt punt1;
    private Punt punt2;
    private Punt punt3;

    public Driehoek(Punt corner1, Punt corner2, Punt corner3) throws DomainException {
        if (corner1 == corner2 || corner2 == corner3 || corner3 == corner1) {
            throw new DomainException("Two or more corners can't be at the same position.");
        } else if (corner1 == null || corner2 == null || corner3 == null) {
            throw new DomainException("Corner can't be null.");
        } else if (liggenOp1Lijn(corner1, corner2, corner3)) {
            throw new DomainException("This triangle is a line...");
        } else {
            this.punt1 = corner1;
            this.punt2 = corner2;
            this.punt3 = corner3;
            //this.sorteerHoekPunten();
        }
    }

    private boolean liggenOp1Lijn(Punt p1, Punt p2, Punt p3) {
        int x1 = p1.getX();
        int y1 = p1.getY();
        int x2 = p2.getX();
        int y2 = p2.getY();
        int x3 = p3.getX();
        int y3 = p3.getY();
        return (x2 - x1) * (y3 - y1) == (x3 - x1) * (y2 - y1);
    }

    public Punt getHoekPunt1() {
        return punt1;
    }

    private void setHoekPunt1(Punt corner1) {
        this.punt1 = corner1;
    }

    public Punt getHoekPunt2() {
        return punt2;
    }

    private void setHoekPunt2(Punt corner2) {
        this.punt2 = corner2;
    }

    public Punt getHoekPunt3() {
        return punt3;
    }

    private void setHoekPunt3(Punt punt3) {
        this.punt3 = punt3;
    }

    private void sorteerHoekPunten() {
        Punt[] corners = {this.getHoekPunt1(), this.getHoekPunt2(), this.getHoekPunt3()};
        Arrays.sort(corners);
        this.setHoekPunt1(corners[0]);
        this.setHoekPunt2(corners[1]);
        this.setHoekPunt3(corners[2]);
    }

    public boolean equals(Driehoek triangle) {
        if (triangle == null){return false;}
        //this.sorteerHoekPunten();
        return this.getHoekPunt1() == triangle.getHoekPunt1() && this.getHoekPunt2() == triangle.getHoekPunt2() && this.getHoekPunt3() == triangle.getHoekPunt3();
    }

    @Override
    public Omhullende omhullende() throws DomainException {
        Punt boxPos = new Punt(min(min(this.getHoekPunt1().getX(), this.getHoekPunt2().getX()), this.getHoekPunt3().getX()),
                min(min(this.getHoekPunt1().getY(), this.getHoekPunt2().getY()), this.getHoekPunt3().getY()));
        int width = max(max(this.getHoekPunt1().getX(), this.getHoekPunt2().getX()), this.getHoekPunt3().getX()) - boxPos.getX();
        int height = max(max(this.getHoekPunt1().getY(), this.getHoekPunt2().getY()), this.getHoekPunt3().getY()) - boxPos.getY();
        return new Omhullende(boxPos, width, height);
    }

    @Override
    public String toString() {
        return String.format("Driehoek: hoekpunt1: %s - hoekpunt2: %s - hoekpunt3: %s", this.getHoekPunt1().toString(), this.getHoekPunt2().toString(), this.getHoekPunt3().toString());
    }
}
