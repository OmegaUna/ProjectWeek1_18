import game.Game;
import game.Player;

import java.util.Scanner;

public class Main {

    public static void main() {
        boolean epicGamerMoment = true;
        Player player = new Player("Dummy");
        Game game = new Game("Test", player, 14);
        Scanner s = new Scanner(System.in);
        while (epicGamerMoment) {
            do {
                System.out.println("Guess a character: ");
            } while (game.isValidGuess(s.nextLine()));
            System.out.println(game.getWordState("_"));
        }
    }
}
