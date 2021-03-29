package domain.shapes;

import domain.exceptions.DomainException;

public class Circle extends Shape{
    private Point center;
    private int radius;

    public Circle(Point center, int radius) throws DomainException {
        if (radius <= 0) {
            throw new DomainException("radius too small (Has to be at least 0)");
        } else if (center == null) {
            throw new DomainException("Circle center is null");
        } else {
            this.center = center;
            this.radius = radius;
        }
    }

    public Point getCenter() {
        return center;
    }

    private void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    private void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean equals(Circle circle) {
        return this.radius == circle.getRadius() && this.center == circle.getCenter();
    }

    @Override
    public void draw() {
        ; //TODO
    }

    @Override
    public String toString() {
        return String.format("Cirkel: middelpunt: %s - straal: %d", this.getCenter().toString(), this.getRadius());
    }
}
