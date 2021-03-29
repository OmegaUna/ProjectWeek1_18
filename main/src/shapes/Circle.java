package shapes;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.awt.*;

public class Circle {
    private Point center;
    private int radius;

    public Circle(Point center, int radius) throws IllegalArgumentException {
        if (radius < 0) {
            throw new IllegalArgumentException("radius too small (Has to be at least 0)");
        } else if (center == null) {
            throw new IllegalArgumentException("Circle center is null");
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

    @Override
    public boolean equals(Object obj) {
        return this.radius == ((Circle) obj).getRadius() && this.center == ((Circle) obj).getCenter();
    }

    @Override
    public String toString() {
        return String.format("Cirkel: middelpunt: (%d, %d) - straal: %d", this.getCenter().x, this.getCenter().y, this.getRadius());
    }
}
