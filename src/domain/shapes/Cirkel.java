package domain.shapes;
import domain.exceptions.*;

import domain.exceptions.DomainException;

import javax.swing.*;

public class Circle extends Shape{
    private Punt center;
    private int radius;

    public Circle(Punt center, int radius) throws DomainException {
        if (radius <= 0) {
            throw new DomainException("radius too small (Has to be at least 0)");
        } else if (center == null) {
            throw new DomainException("Circle center is null");
        } else {
            this.center = center;
            this.radius = radius;
        }
    }

    public Punt getCenter() {
        return center;
    }

    private void setCenter(Punt center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    private void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean equals(Circle circle) {
        if(circle == null) return false;
        return this.radius == circle.getRadius() && this.center == circle.getCenter();
    }

    @Override
    public BoxAround boxAround() {
        Point boxPos = new Point(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius());
        int width = this.getRadius() * 2;
        int height = this.getRadius() * 2;
        return new BoxAround(boxPos, width, height);
    }

    @Override
    public String toString() {
        return String.format("Cirkel: middelpunt: %s - straal: %d", this.getCenter().toString(), this.getRadius());
    }
}
