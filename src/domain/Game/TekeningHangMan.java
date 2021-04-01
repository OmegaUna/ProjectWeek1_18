package domain.game;

import domain.exceptions.DomainException;
import domain.shapes.*;

public class TekeningHangMan extends Tekening {

    public TekeningHangMan(String naamTekening) throws DomainException {
        super(naamTekening);
        Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);// altijd zichtbaar
        Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50)); // altijd zichtbaar
        Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50)); // altijd zichtbaar
        Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100)); // altijd zichtbaar
        Vorm hoofd = new Cirkel(new Punt(280, 125), 25); // zichtbaar na 1 fout
        Vorm oogLinks = new Cirkel(new Punt(270, 118), 2); // zichtbaar na 2 fouten
        Vorm oogRechts = new Cirkel(new Punt(290, 118), 2); //…
        Vorm neus = new Cirkel(new Punt(280, 128), 2);
        Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
        Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
        Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
        Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
        Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
        Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
        Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
        Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
        Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
        Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
        Vorm[] vormenArray = {galgBodem, galgStaaf, hangbar, koord, hoofd, oogLinks, oogRechts, neus, mond, lijf,
                beenLinks, beenRechts, voetLinks, voetRechts, armLinks, armRechts, handLinks, handRechts};
        try {
            for (Vorm vorm : vormenArray) super.voegToe(vorm);
        } catch (DomainException e) {
            System.out.println("we kinda fucked up");
        }
    }

    public int getAantalZichtbaar() {
        int zichtbaar = 0;
        for (Vorm vorm : this.getVormen()) if (vorm.isZichtbaar()) zichtbaar++;
        return zichtbaar;
    }


    public void zetVolgendeZichtbaar() {
        for (Vorm vorm : this.getVormen()) {
            if (!vorm.isZichtbaar()) {
                vorm.setZichtbaar(true);
                return;
            }
        }
    }

    @Override
    public void voegToe(Vorm vorm) throws DomainException {
        throw new DomainException("Je mag geen vormen toevoegen aan de hangman tekening >:(");
    }

    @Override
    public void verwijder(Vorm vorm) throws DomainException {
        throw new DomainException("Je mag geen vormen verwijderen van de hangman tekening >:(");
    }
}
