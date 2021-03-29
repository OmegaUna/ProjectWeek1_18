package game;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Game {

    private String word;
    private Player player;
    private int maxGuesses;
    private ArrayList<Character> guessedChars = new ArrayList();

    public void Game(String word, Player player, int maxGuesses) {
        this.word = word;
        this.player = player;
        this.maxGuesses = maxGuesses;
    }

    public String getWord() {
        return word;
    }

    public String getWordState(String blank) {
        String wordState = "";
        for (Character letter : this.getWord().toCharArray()) {
            if (this.getGuessedChars().contains(letter)) {
                wordState.concat(letter.toString());
            } else {
                wordState.concat(blank);
            }
        }
        return wordState;
    }

    public Player getPlayer() {
        return player;
    }

    public int getMaxGuesses() {
        return maxGuesses;
    }

    public void setMaxGuesses(int maxGuesses) {
        this.maxGuesses = maxGuesses;
    }

    public ArrayList<Character> getGuessedChars() {
        return guessedChars;
    }

    public void addGuessedChar(Character character) {
        this.guessedChars.add(character);
    }

    public boolean isValidGuess(Character character) {
        return !this.getGuessedChars().contains(character);
    }

    public boolean guess(Character character) {
        addGuessedChar(character);
        return this.getWord().indexOf(character) != -1;
    }
}
