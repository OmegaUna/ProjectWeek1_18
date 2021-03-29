package shapes;

public class Circle extends Shape{
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
