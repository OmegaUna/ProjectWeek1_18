import java.util.ArrayList;

public class Logic {


    private ArrayList<String> usedLetters = new ArrayList<>();
    private String wordAnswer;

    public void addUsedLetter(String letter) {
        usedLetters.add(letter);
    }
    public boolean checkLetter(String letter) {
        return this.usedLetters.get(0).equals(letter); // random placeholder
    }

}
