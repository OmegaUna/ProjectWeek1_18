public class Rectangle {
    private int breedte, hoogte;
    private Punt linkerBovenHoek;

    public Rectangle(Punt punt, int breedte, int hoogte) {
            this.breedte = breedte;
            this.hoogte = hoogte;
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
}