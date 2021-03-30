package domain.Game;

import static java.lang.Integer.max;
import static java.lang.Integer.sum;

import domain.exceptions.*;

public class Speler {

    private String name;
    private int score;

    public Speler(String name) throws DomainException {
        setName(name);
        setScore(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws DomainException {
        this.name = name;

        if(name==null||name.trim().isEmpty()) throw new DomainException("Naam mag niet leeg zijn.");
    }

    public int getScore() {

        return score;
    }

    public void setScore(int score) throws DomainException {
        if(score<0) throw new DomainException("Score negatief.");
        this.score = score;
    }

    public void addToScore(int add) throws DomainException {
        if(sum(add,score)<0) throw new DomainException("score negatief.");
        this.score += add;
    }

    private void validateScore() throws DomainException {
        this.setScore(max(0, this.score));
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) return false;
        return this.getName().equals(((Speler) obj).getName()) && this.getScore() == ((Speler) obj).getScore();
    }

    @Override
    public String toString() {
        return this.name + " " + this.score;
    }
}
