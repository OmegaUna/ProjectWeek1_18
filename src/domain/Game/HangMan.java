package domain.game;

import domain.exceptions.DomainException;

public class HangMan {

    Speler speler;
    TekeningHangMan tekeningHangMan;
    Woordenlijst woordenlijst;
    HintWoord hintWoord;
    boolean gewonnen;
    private int guesses;

    public final int MAXGUESSES = 14;

    public HangMan(Speler speler, Woordenlijst woordenlijst) throws DomainException {
        this.speler = speler;
        this.woordenlijst = woordenlijst == null ? new Woordenlijst() : woordenlijst;
        this.tekeningHangMan = new TekeningHangMan("HangMan");
        this.hintWoord = new HintWoord(this.woordenlijst.getRandomWord());
        this.guesses = 0;
    }

    public Speler getSpeler() {
        return this.speler;
    }

    public String getWord() {
        return this.hintWoord.getWoord();
    }

    public TekeningHangMan getTekening() {
        return this.tekeningHangMan;
    }

    public String getHint() {
        return this.hintWoord.toString();
    }

    public int getGuesses() {
        return this.guesses;
    }

    public boolean isGameOver() {
        return this.guesses == this.MAXGUESSES;
    }

    public boolean isGewonnen() {
        return this.hintWoord.isGeraden();
    }
    
    public boolean raad(char character) {
        if (this.hintWoord.raad(character)) {
            return true;
        } else {
            guesses++;
            return false;
        }
    }
}
