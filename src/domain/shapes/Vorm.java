package domain.shapes;

import domain.exceptions.DomainException;

import java.awt.*;

public abstract class Vorm implements Drawable{

    private Color kleur;
    private boolean isZichtbaar;

    public Color getKleur() {
        return this.kleur;
    }

    public void setKleur(Color kleur) {
        this.kleur = kleur;
    }

    public boolean isZichtbaar() {
        return this.isZichtbaar;
    }

    public void setZichtbaar(boolean bool) {
        this.isZichtbaar = bool;
    }

    public abstract Omhullende getOmhullende() throws DomainException;

    public abstract String toString();
}
