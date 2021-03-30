package domain.game;

import domain.shapes.Vorm;

import java.util.ArrayList;

public class Tekening {
    private String naam;
    private ArrayList<Vorm> vormen = new ArrayList<>();
    public int MIN_X;
    public int MIN_Y;
    public int MAX_X;
    public int MAX_Y;

    public Tekening(String naamTekening) {
        this.naam = naamTekening;
    }

    public static boolean isValidNaam(String naamTekening) {
        return !naamTekening.trim().isEmpty();
    }
    public String getNaam() {
        return this.naam;
    }

    public int getAantalVormen() {
        return this.vormen.size();
    }

    public Vorm getVorm(int index) {
        return this.vormen.get(index);
    }

    public void voegToe(Vorm vorm) {
        this.vormen.add(vorm);
    }

    public boolean bevat(Vorm vorm) {
        return this.vormen.contains(vorm);
    }

    public void verwijder(Vorm vorm) {
        this.vormen.remove(vorm);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tekening tekening = (Tekening) o;
        return MIN_X == tekening.MIN_X &&
                MIN_Y == tekening.MIN_Y &&
                MAX_X == tekening.MAX_X &&
                MAX_Y == tekening.MAX_Y &&
                naam.equals(tekening.naam) &&
                vormen.equals(tekening.vormen);
    }
    @Override
    public String toString() {
        return "Tekening{" +
                "naam='" + naam + '\'' +
                ", vormen=" + vormen +
                ", MIN_X=" + MIN_X +
                ", MIN_Y=" + MIN_Y +
                ", MAX_X=" + MAX_X +
                ", MAX_Y=" + MAX_Y +
                '}';
    }
}
