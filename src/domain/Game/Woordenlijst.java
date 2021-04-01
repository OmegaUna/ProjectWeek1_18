package domain.game;

import domain.exceptions.DomainException;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class Woordenlijst {

    private final String PATH;

    public Woordenlijst(String name) {
        this.PATH = "rsc/" + name;
    }

    public Woordenlijst() {
        this.PATH = "rsc/hangmanZeerSpicy.txt";
    }

    // nothing makes sense but okay!
    public void voegToe(String s) throws DomainException {
        if (inWordList(s)) {
            throw new DomainException();
        } else {
            try {
                FileWriter myWriter = new FileWriter(PATH);
                myWriter.write(s);
                myWriter.close();
            } catch (IOException e) {
                throw new DomainException(e.getMessage());
            }
        }
    }

    private boolean inWordList(String word) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(PATH));
            for (int lineNr = 0; lineNr <= getAantalWoorden(); lineNr++) {
                String line = reader.readLine();
                if (line.equals(word)) return true;
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }


    public String getRandomWord() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, getAantalWoorden());
        BufferedReader reader;
        String line = "dummy string in case of io exception";
        try {
            reader = new BufferedReader(new FileReader(PATH));
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
        int lines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PATH));
            while (reader.readLine() != null) lines++;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return lines;
    }
}
