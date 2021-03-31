package domain.game;

public class HintLetter {

    private final char letter;
    private boolean isGeraden;

    public HintLetter(char letter) {
        this.letter = letter;
        this.isGeraden = false;
    }

    public char getLetter() {
        return this.letter;
    }

    public boolean raad(char letter) {
        if (Character.toLowerCase(this.getLetter()) == Character.toLowerCase(letter) && !this.isGeraden()) {
            this.isGeraden = true;
            return true;
        } else {
            return false;
        }
    }

    public char toChar() {
        return this.isGeraden() ? this.letter : '_';
    }

    public boolean isGeraden() {
        return this.isGeraden;
    }
}
