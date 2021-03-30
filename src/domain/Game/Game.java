package domain.Game;

import java.util.ArrayList;

public class Game {

    private String word;
    private Speler speler;
    private int maxGuesses;
    private int wrongGuesses;
    private ArrayList<String> guessedChars = new ArrayList();

    public Game(String word, Speler speler, int maxGuesses) {
        this.word = word.toLowerCase();
        this.speler = speler;
        this.maxGuesses = maxGuesses;
        this.wrongGuesses = 0;
    }

    public String getWord() {
        return word;
    }

    public String getWordState(String blank) {
        String wordState = "";
        for (Character letter : this.getWord().toCharArray()) {
            if (this.getGuessedChars().contains(letter.toString().toLowerCase())) {
                wordState = wordState.concat(letter.toString().toLowerCase());
            } else {
                wordState = wordState.concat(blank);
            }
        }
        return wordState;
    }

    private boolean isLetterInWord(String letter) {
        return this.getWord().contains(letter.toLowerCase());
    }

    public boolean complete() {
        return this.getWordState("_").toLowerCase().equals(this.getWord());
    }

    public boolean lost() {
        return this.getWrongGuesses() >= this.maxGuesses;
    }

    public int getWrongGuesses() {
        return this.wrongGuesses;
    }

    public void addWrongGuess() {
        this.wrongGuesses += 1;
    }

    public Speler getPlayer() {
        return speler;
    }

    public int getMaxGuesses() {
        return maxGuesses;
    }

    public void setMaxGuesses(int maxGuesses) {
        this.maxGuesses = maxGuesses;
    }

    public ArrayList<String> getGuessedChars() {
        return guessedChars;
    }

    public void addGuessedChar(String character) {
        this.guessedChars.add(character);
    }

    public boolean isValidGuess(String character) {
        return character.length() == 1 && !this.getGuessedChars().contains(character.toLowerCase());
    }

    public boolean guess(String character) {
        addGuessedChar(character.toLowerCase());
        return isLetterInWord(character);
    }
}
