public class Rectangle {
    private int breedte, hoogte;
    private Punt linkerBovenHoek;

    public Rectangle(Punt punt, int breedte, int hoogte) {
        if(breedte <= 0) throw new IllegalArgumentException();
        this.breedte = breedte;
        if(hoogte <= 0) throw new IllegalArgumentException();
        this.hoogte = hoogte;
        if(punt == null) throw new IllegalArgumentException();
        this.linkerBovenHoek = punt;
    }

    public int getBreedte() {
        return breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public Punt getLinkerBovenHoek() {
        return linkerBovenHoek;
    }

    public boolean equals(Object obj) {
        return this.breedte == ((Rectangle) obj).getBreedte() && this.hoogte == ((Rectangle) obj).getHoogte() && this.linkerBovenHoek == ((Rectangle) obj).getLinkerBovenHoek();
    }

    public String toString() {
        return "Rechthoek: linkerbovenhoek: (" + this.linkerBovenHoek.getX() + ", " + this.linkerBovenHoek.getY() + ") - breedte: " + this.getBreedte() + " - hoogte: " + this.getHoogte();
    }
}