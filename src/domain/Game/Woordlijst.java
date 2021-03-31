package domain.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Woordlijst {

    private static final File WORDS = new File("hangmanZeerSpicy.txt");
    private static final int WORDSLENGTH = 194445;
    private final ArrayList<String> woordenLijst;

    public Woordlijst() {
        this.woordenLijst = new ArrayList<>();
    }

    // nothing makes sense but okay!
    public void voegToe(String s) throws IOException {
        // add String or add from woordenlijst

        // add from woordenlijst
        if (this.woordenLijst.contains(s)) {
            throw new IOException();
        } else {
            // zoek s
            Scanner reader = new Scanner(WORDS);
            if (WORDS.exists()) {
                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
                    woordenLijst.add(data);
                }
            }
        }
    }

    public static String getRandomWord() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, WORDSLENGTH);
        BufferedReader reader;
        String line = "dummy string in case of io exception";
        try {
            reader = new BufferedReader(new FileReader("rsc/hangmanZeerSpicy.txt"));
            for (int lineNr = 0; lineNr <= randomNum; lineNr++) {
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return line;
    }

    public int getAantalWoorden() {
        return this.woordenLijst.size();
    }
}
