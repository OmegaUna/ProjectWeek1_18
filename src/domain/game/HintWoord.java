package domain.game;

import domain.exceptions.DomainException;

import java.util.ArrayList;

public class HintWoord {

    private HintLetter[] hintWoord;
    private ArrayList<Character> guessedChars = new ArrayList();

    public HintWoord(String woord) throws DomainException {
        if(woord==null||woord.trim().isEmpty()) throw new DomainException("Woord was null of leeg");
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
                hl.raad(Character.toLowerCase(letter));
            }
            addGuessedChar(letter);
        } else return false;
        return isInWoord(letter);
    }

    private boolean isInWoord(char letter) {
        return this.getWoord().contains(String.valueOf(Character.toLowerCase(letter)));
    }

    public boolean isGeraden() {
        return !this.toString().contains("_");
    }

    public String getWoord() {
        String woord = "";

        //for (HintLetter letter : this.getHintWoord()) woord = woord.concat(letter.toString());
        HintLetter[] lijst = this.getHintWoord();
        for (int i = 0; i < this.getHintWoord().length; i++) {
            woord=woord.concat(Character.toString(lijst[i].getLetter()));
        }
        return woord;
    }

    private HintLetter[] getHintWoord() {
        return this.hintWoord;
    }

    private ArrayList<Character> getGuessedChars() {
        return this.guessedChars;
    }

    public void addGuessedChar(Character character) {
        this.guessedChars.add(Character.toLowerCase(character));
    }

    public String toString() {
        String str = "";
        HintLetter[] lijst = this.getHintWoord();
        for (int i=0; i<getHintWoord().length;i++){ //HintLetter hl : this.getHintWoord()) {
            HintLetter hl = lijst[i];
            str = str.concat(Character.toString(hl.toChar()));
            if(i== lijst.length-1) return str;
            if(hl.getLetter()!=' ') str = str.concat(" ");
        }
        return str;
    }
}
