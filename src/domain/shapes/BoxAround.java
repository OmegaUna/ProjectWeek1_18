package domain.shapes;

public class BoxAround {

    private final int width;
    private final int height;
    private final Punt lUCorner;

    public BoxAround(Punt lUCorner, int width, int height) {
        this.lUCorner = lUCorner;
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Punt getLUCorner() {
        return lUCorner;
    }

    public int getMinX() {
        return this.lUCorner.getX();
    }

    public int getMinY() {
        return this.lUCorner.getY();
    }

    public int getMaxX() {
        return this.lUCorner.getX() + this.getWidth();
    }

    public int getMaxY() {
        return this.lUCorner.getY() + this.getHeight();
    }

    public boolean equals(BoxAround boxAround) {
        return this.lUCorner == boxAround.getLUCorner() && this.width == boxAround.getWidth() && this.height == boxAround.getHeight();
    }

    @Override
    public String toString() {
        return String.format("Omhullende: %s - %d - %d", this.getLUCorner(), this.getWidth(), this.getHeight());
    }
}
