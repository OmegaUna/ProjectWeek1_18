import game.Game;
import game.Player;

import java.util.Scanner;

public class Main {

    private static boolean epicGamerMoment = true;

    public void main() {
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
