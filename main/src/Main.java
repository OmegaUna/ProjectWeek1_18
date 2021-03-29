import game.Game;
import game.Player;

import java.util.Scanner;

import static javafx.application.Application.launch;

public class Main {



    public static void main(String[] args) {
//        launch(args);
        boolean epicGamerMoment = true;
        Player player = new Player("Dummy");
        Game game = new Game("Test", player, 14);
        Scanner s = new Scanner(System.in);
        String guess;
        while (!game.complete()) {
            do {
                System.out.println("Guess a character: ");
                guess = s.nextLine();
            } while (!game.isValidGuess(guess));
            game.guess(guess);
            System.out.println(game.getGuessedChars());
            System.out.println(game.getWordState("_"));
        }
    }
}
