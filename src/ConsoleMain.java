import domain.exceptions.DomainException;
import domain.game.HintWoord;

import java.util.Scanner;

public class ConsoleMain {

    private static int MAXGUESSES = 14;

    public static void main(String[] args) throws DomainException {
//        launch(args);
        boolean epicGamerMoment = true;
//        Speler speler = new Speler("Dummy");
        Scanner s = new Scanner(System.in);
        HintWoord hintWoord = new HintWoord("testje");
        String guess;
        char charGuess = '_';
        while (!hintWoord.isGeraden()) {
            System.out.println("Guess a character: ");
            guess = s.nextLine();
            charGuess = guess.length() == 1 ? guess.toCharArray()[0] : '*';
            hintWoord.raad(charGuess);
            System.out.println(hintWoord.toString());
        }
    }
}
