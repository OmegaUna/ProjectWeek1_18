import domain.Game.Game;
import domain.Game.Player;

import java.util.Scanner;

import static javafx.application.Application.launch;

public class ConsoleMain {

    private static int MAXGUESSES = 14;

    public static void main(String[] args) {
//        launch(args);
        boolean epicGamerMoment = true;
        Player player = new Player("Dummy");
        Game game = new Game("test", player, MAXGUESSES);
        Scanner s = new Scanner(System.in);
        String guess;
        while (!game.complete() && !game.lost()) {
            do {
                System.out.println("Guess a character: ");
                guess = s.nextLine();
            } while (!game.isValidGuess(guess));
            if (!game.guess(guess)) {
                game.addWrongGuess();
            }
            System.out.println(game.getGuessedChars());
            System.out.println(game.getWordState("_"));
        }
    }
}
