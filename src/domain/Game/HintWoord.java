package domain.game;

import java.util.ArrayList;

public class HintWoord {

    private HintLetter[] hintWoord;
    private ArrayList<Character> guessedChars = new ArrayList();

    public HintWoord(String woord) {
        this.hintWoord = stringToHintLetterArray(woord);
    }

    private HintLetter[] stringToHintLetterArray(String string) {
        HintLetter[] hintLetterArray = new HintLetter[string.length()];
        int count = 0;
        for (char letter : string.toCharArray()) {
            hintLetterArray[count++] = new HintLetter(letter);
        }
        return hintLetterArray;
    }

    public boolean raad(char letter) {
        if (!getGuessedChars().contains(letter)) {
            for (HintLetter hl : this.getHintWoord()) {
                hl.raad(letter);
            }
            addGuessedChar(letter);
        } else return false;
        return isInWoord(letter);
    }

    private boolean isInWoord(char letter) {
        return this.getWoord().contains(String.valueOf(letter));
    }

    public boolean isGeraden() {
        return !this.toString().contains("_");
    }

    public String getWoord() {
        String woord = "";
        for (HintLetter letter : hintWoord) woord = woord.concat(letter.toString());
        return woord;
    }

    private HintLetter[] getHintWoord() {
        return this.hintWoord;
    }

    private ArrayList<Character> getGuessedChars() {
        return this.guessedChars;
    }

    public void addGuessedChar(Character character) {
        this.guessedChars.add(character);
    }

    public String toString() {
        String str = "";
        for (HintLetter hl : this.getHintWoord()) {
            str = str.concat(Character.toString(hl.toChar()));
        }
        return str;
    }
}
