import java.util.ArrayList;

public class Logic {


    private ArrayList<String> usedLetters = new ArrayList<>();
    private String wordAnswer = "";
    private int guessedCount = 0;
    private int max_guesses = 0;



    public void addUsedLetter(String letter) {
        this.usedLetters.add(letter);
        this.guessedCount++;
    }
    /*  Button:onclick => checkLetter */
    public boolean checkLetter(String letter) {
        this.addUsedLetter(letter);
        if ( wordAnswer.contains(letter) && !this.usedLetters.contains(letter) ) {
            return true;
        } else {
            if (guessedCount == max_guesses) this.loseGame();
            return false;
        }
    }

    /*   Change text to output => winGame */
    public void winGame() {
        System.out.println("You have won the game!");
    }
    /*   Change text to output => loseGame */
    public void loseGame() {
        System.out.println("You have losed the game!");
    }

}
