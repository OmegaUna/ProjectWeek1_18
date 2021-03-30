package domain.shapes;

import domain.exceptions.DomainException;

import java.awt.*;

public abstract class Vorm {

    private Color kleur;

    public Color getKleur() {
        return this.kleur;
    }

    public void setKleur(Color kleur) {
        this.kleur = kleur;
    }

    public abstract Omhullende omhullende() throws DomainException;

    public abstract String toString();
}
