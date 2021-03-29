package ui.logic;

import static java.lang.Integer.max;

public class Player {

    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
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
