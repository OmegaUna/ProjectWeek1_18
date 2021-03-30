package domain.shapes;

public class Punt {

    private final int x;
    private final int y;

    public Punt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Punt punt) {
        if(punt == null)return false;
        return this.getX() == punt.getX() && this.getY() == punt.getY();
    }

    public int compareTo(Punt punt) {
        return this.getX() - punt.getX();
    }

    @Override
    public String toString() {
        return String.format("(%s %s)", this.getX(), this.getY());
    }
}
