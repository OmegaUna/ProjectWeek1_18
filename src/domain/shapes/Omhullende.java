package domain.shapes;

import domain.exceptions.DomainException;

public class Omhullende {

    private final int width;
    private final int height;
    private final Punt lUCorner;

    public Omhullende(Punt lUCorner, int width, int height) throws DomainException {
        if(height<0) throw new DomainException("Hoogte was kleiner dan 0");
        if(lUCorner==null) throw new DomainException("Linkerbovenhoek was null");
        if(width<0) throw new DomainException("Breedte was kleiner dan 0");
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

    public boolean equals(Omhullende boxAround) {
        if(boxAround==null) return false;
        return this.lUCorner == boxAround.getLUCorner() && this.width == boxAround.getWidth() && this.height == boxAround.getHeight();
    }

    @Override
    public String toString() {
        return String.format("Omhullende: %s - %d - %d", this.getLUCorner(), this.getWidth(), this.getHeight());
    }

}
