package domain.shapes;

import static org.junit.Assert.*;

import domain.exceptions.DomainException;
import domain.shapes.Punt;
import domain.shapes.Rechthoek;
import org.junit.Before;
import org.junit.Test;

public class RechthoekTest {

    private Punt linkerBovenhoek;
    private int breedte, hoogte;
    private Rechthoek rechthoek;

    @Before
    public void setUp() throws DomainException {
        linkerBovenhoek = new Punt(200, 200);
        breedte = 20;
        hoogte = 40;
        rechthoek = new Rechthoek(linkerBovenhoek,hoogte, breedte);
    }

    @Test
    public void Rechthoek_moet_rechthoek_aanmaken_met_gegeven_linkerbovenhoek_breedte_en_hoogte() throws DomainException {
        Rechthoek rechthoek = new Rechthoek(linkerBovenhoek,hoogte, breedte);
        assertEquals(linkerBovenhoek, rechthoek.getLUCorner());
        assertEquals(hoogte, rechthoek.getHeight());
        assertEquals(breedte, rechthoek.getWidth());
    }

    @Test (expected = DomainException.class)
    public void Rechthoek_Moet_exception_gooien_als_linkerbovenhoek_null() throws DomainException {
        new Rechthoek(null, hoogte, breedte);
    }

    @Test (expected = DomainException.class)
    public void Rechthoek_Moet_exception_gooien_als_breedte_kleiner_dan_0() throws DomainException {
        new Rechthoek(linkerBovenhoek, -1, breedte);
    }

    @Test (expected = DomainException.class)
    public void Rechthoek_Moet_exception_gooien_als_hoogte_kleiner_dan_0() throws DomainException {
        new Rechthoek(linkerBovenhoek, hoogte, -1);

    }

    @Test (expected = DomainException.class)
    public void Rechthoek_Moet_exception_gooien_als_breedte_gelijk_aan_0() throws DomainException {
        new Rechthoek(linkerBovenhoek, 0, breedte);
    }

    @Test (expected = DomainException.class)
    public void Rechthoek_Moet_exception_gooien_als_hoogte_gelijk_aan_dan_0() throws DomainException {
        new Rechthoek(linkerBovenhoek, hoogte  , 0);
    }

    @Test
    public void equals_moet_true_teruggeven_als_linkerbovenhoek_breedte_hoogte_gelijk_zijn() throws DomainException {
        Rechthoek zelfdeRechthoek = new Rechthoek(linkerBovenhoek,hoogte, breedte);
        assertTrue(rechthoek.equals(zelfdeRechthoek));
    }

    @Test
    public void equals_moet_false_teruggeven_als_linkerbovenhoek_verschilt() throws DomainException {
        Punt andereLinkerBovenhoek = new Punt(100,100);
        Rechthoek verschillendeRechthoek = new Rechthoek(andereLinkerBovenhoek, hoogte, breedte);
        assertFalse(rechthoek.equals(verschillendeRechthoek));
    }

    @Test
    public void equals_moet_false_teruggeven_als_breedte_verschilt() throws DomainException {
        Rechthoek verschillendeRechthoek = new Rechthoek(linkerBovenhoek, hoogte + 10, breedte);
        assertFalse(rechthoek.equals(verschillendeRechthoek));
    }

    @Test
    public void equals_moet_false_teruggeven_als_hoogte_verschilt() throws DomainException {
        Rechthoek verschillendeRechthoek = new Rechthoek(linkerBovenhoek, hoogte, breedte + 10);
        assertFalse(rechthoek.equals(verschillendeRechthoek));
    }

    @Test
    public void equals_moet_false_teruggeven_als_parameter_null(){
        assertFalse(rechthoek.equals(null));
    }
}