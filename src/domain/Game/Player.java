package domain.game;

import domain.exceptions.DomainException;

import static java.lang.Integer.max;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Player {

    private String name;
    private int score;

    public Player(String name) throws DomainException {
        Pattern p = Pattern.compile("[\\s\\S]*\\S[\\s\\S]*");
        Matcher matcher = p.matcher(name);
        if (matcher.find()) {
            this.name = name;
            this.score = 0;
        } else {
            throw new DomainException();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addToScore(int add) {
        this.score += add;
    }

    private void validateScore() {
        this.setScore(max(0, this.score));
    }

    @Override
    public boolean equals(Object obj) {
        return this.getName().equals(((Player) obj).getName()) && this.getScore() == ((Player) obj).getScore();
    }

    @Override
    public String toString() {
        return this.name + " " + this.score;
    }
}
