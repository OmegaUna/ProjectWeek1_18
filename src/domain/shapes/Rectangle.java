package domain.shapes;

import domain.exceptions.DomainException;

public class Rectangle extends Shape {

    private final int width;
    private final int height;
    private final Point lUCorner;

    public Rectangle(Point punt, int height, int width) throws DomainException {
        if (height <= 0) {
            throw new DomainException("Width too small (Should be >0)");
        } else if (width <= 0) {
            throw new DomainException("Height too small (Should be >0)");
        } else if (punt == null) {
            throw new DomainException("Point can't be null");
        } else {
            this.width = width;
            this.height = height;
            this.lUCorner = punt;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Point getLUCorner() {
        return lUCorner;
    }

    public boolean equals(Rectangle rectangle) {
        return this.lUCorner == rectangle.getLUCorner() && this.width == rectangle.getWidth() && this.height == rectangle.getHeight();
    }

    @Override
    public String boxAround() {
        return this.toString() + String.format("\nOmhullende: %s - %d - %d", this.getLUCorner().toString(), this.getWidth(), this.getHeight());
    }

    @Override
    public void draw() {
        ; //TODO
    }

    @Override
    public String toString() {
        return String.format("Rechthoek: linkerbovenhoek: %s - breedte: %d - hoogte: %d", this.getLUCorner().toString(), this.getWidth(), this.getHeight());
    }
}