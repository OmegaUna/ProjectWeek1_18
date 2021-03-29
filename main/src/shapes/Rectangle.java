package shapes;

public class Rectangle {

    private final int width;
    private final int height;
    private final Point lUCorner;

    public Rectangle(Point punt, int height, int width) {
        if (height <= 0) {
            throw new IllegalArgumentException("Width too small (Should be >0)");
        } else if (width <= 0) {
            throw new IllegalArgumentException("Height too small (Should be >0)");
        } else if (punt == null) {
            throw new IllegalArgumentException("Point can't be null");
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

    public boolean equals(Object obj) {
        return this.lUCorner == ((Rectangle) obj).getLUCorner() && this.width == ((Rectangle) obj).getWidth() && this.height == ((Rectangle) obj).getHeight();
    }

    public String toString() {
        return String.format("Rechthoek: linkerbovenhoek: (%s, %s) - breedte: %s - hoogte: %s",
                this.lUCorner.getX(), this.lUCorner.getY(), this.getWidth(), this.getHeight());
    }
}