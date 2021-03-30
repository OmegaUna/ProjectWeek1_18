package domain.shapes;

import domain.exceptions.DomainException;

public class Rechthoek extends Vorm {

    private final int width;
    private final int height;
    private final Punt lUCorner;

    public Rechthoek(Punt punt, int height, int width) throws DomainException {
        if (height <= 0) {
            throw new DomainException("Width too small (Should be >0)");
        } else if (width <= 0) {
            throw new DomainException("Height too small (Should be >0)");
        } else if (punt == null) {
            throw new DomainException("Punt can't be null");
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

    public Punt getLUCorner() {
        return lUCorner;
    }

    public boolean equals(Rechthoek rechthoek) {
        if (rechthoek==null) return false;
        return this.lUCorner == rechthoek.getLUCorner() && this.width == rechthoek.getWidth() && this.height == rechthoek.getHeight();
    }

    @Override
    public Omhullende omhullende() throws DomainException {
        return new Omhullende(this.lUCorner, width, height);
    }

    @Override
    public String toString() {
        return String.format("Rechthoek: linkerbovenhoek: %s - breedte: %d - hoogte: %d", this.getLUCorner().toString(), this.getWidth(), this.getHeight());
    }
}