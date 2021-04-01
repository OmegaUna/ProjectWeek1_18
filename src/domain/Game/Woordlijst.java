package domain.game;

import domain.exceptions.DomainException;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class Woordlijst {

    private static final String WORDSPATH = "rsc/hangmanZeerSpicy.txt";

    // nothing makes sense but okay!
    public static void voegToe(String s) throws DomainException {
        if (inWordList(s)) {
            throw new DomainException();
        } else {
            try {
                FileWriter myWriter = new FileWriter(WORDSPATH);
                myWriter.write(s);
                myWriter.close();
            } catch (IOException e) {
                throw new DomainException(e.getMessage());
            }
        }
    }

    private static boolean inWordList(String word) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(WORDSPATH));
            for (int lineNr = 0; lineNr <= getAantalWoorden(); lineNr++) {
                String line = reader.readLine();
                if (line.equals(word)) return true;
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }


    public static String getRandomWord() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, getAantalWoorden());
        BufferedReader reader;
        String line = "dummy string in case of io exception";
        try {
            reader = new BufferedReader(new FileReader(WORDSPATH));
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

    public static int getAantalWoorden() {
        int lines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(WORDSPATH));
            while (reader.readLine() != null) lines++;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return lines;
    }
}
