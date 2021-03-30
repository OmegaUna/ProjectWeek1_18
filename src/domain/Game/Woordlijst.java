package domain.Game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Woordlijst {
    private final ArrayList<String> woordenLijst;
    public Woordlijst() {
        this.woordenLijst = new ArrayList<>();
    }
    // nothing makes sense but okay!
    public void voegToe(String s) throws IOException {
        // add String or add from woordenlijst

        // add from woordenlijst
        if ( this.woordenLijst.contains(s) ) {
            throw new IOException();
        } else {
            // zoek s
            File file = new File("woordenlijst.txt");
            Scanner reader = new Scanner(file);
            if (file.exists()) {
                while(reader.hasNextLine()) {
                    String data = reader.nextLine();
                    woordenLijst.add(data);
                }
            }
        }
    }

    public int getAantalWoorden() {
        return this.woordenLijst.size();
    }
}
