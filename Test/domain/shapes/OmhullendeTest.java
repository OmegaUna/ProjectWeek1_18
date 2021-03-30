package domain.shapes;

import static org.junit.Assert.*;

import domain.exceptions.DomainException;
import domain.shapes.Omhullende;
import domain.shapes.Punt;
import org.junit.Before;
import org.junit.Test;

public class OmhullendeTest {

    private Punt linkerBovenhoek;
    private int breedte, hoogte;
    private Omhullende Omhullende;

    @Before
    public void setUp() throws DomainException {
        linkerBovenhoek = new Punt(200, 200);
        breedte = 20;
        hoogte = 40;
        Omhullende = new Omhullende(linkerBovenhoek,breedte, hoogte);
    }

    @Test
    public void Omhullende_moet_Omhullende_aanmaken_met_gegeven_linkerbovenhoek_breedte_en_hoogte() throws DomainException {
        Omhullende Omhullende = new Omhullende(linkerBovenhoek,breedte, hoogte);
        assertEquals(linkerBovenhoek, Omhullende.getLUCorner());
        assertEquals(hoogte, Omhullende.getHeight());
        assertEquals(breedte, Omhullende.getWidth());
    }

    @Test (expected = DomainException.class)
    public void Omhullende_Moet_exception_gooien_als_linkerbovenhoek_null() throws DomainException {
        new Omhullende(null, breedte, hoogte);
    }

    @Test (expected = DomainException.class)
    public void Omhullende_Moet_exception_gooien_als_breedte_kleiner_dan_0() throws DomainException {
        new Omhullende(linkerBovenhoek, -1, hoogte);
    }

    @Test (expected = DomainException.class)
    public void Omhullende_Moet_exception_gooien_als_hoogte_kleiner_dan_0() throws DomainException {
        new Omhullende(linkerBovenhoek, breedte, -1);
    }

    @Test
    public void Omhullende_Moet_Omhullende_maken_als_breedte_gelijk_aan_0() throws DomainException {
        Omhullende Omhullende = new Omhullende(linkerBovenhoek,0, hoogte);
        assertEquals(0, Omhullende.getWidth());
    }

    @Test
    public void Omhullende_Moet_Omhullende_maken_als_hoogte_gelijk_aan_0() throws DomainException {
        Omhullende Omhullende = new Omhullende(linkerBovenhoek,breedte, 0);
        assertEquals(0, Omhullende.getHeight());
    }

    @Test
    public void equals_moet_true_teruggeven_als_linkerbovenhoek_breedte_hoogte_gelijk_zijn() throws DomainException {
        Omhullende zelfdeOmhullende = new Omhullende(linkerBovenhoek,breedte, hoogte);
        assertTrue(Omhullende.equals(zelfdeOmhullende));
    }

    @Test
    public void equals_moet_false_teruggeven_als_linkerbovenhoek_verschilt() throws DomainException {
        Punt andereLinkerBovenhoek = new Punt(100,100);
        Omhullende verschillendeOmhullende = new Omhullende(andereLinkerBovenhoek, breedte, hoogte);
        assertFalse(Omhullende.equals(verschillendeOmhullende));
    }

    @Test
    public void equals_moet_false_teruggeven_als_breedte_verschilt() throws DomainException {
        Omhullende verschillendeOmhullende = new Omhullende(linkerBovenhoek, breedte + 10, hoogte);
        assertFalse(Omhullende.equals(verschillendeOmhullende));
    }

    @Test
    public void equals_moet_false_teruggeven_als_hoogte_verschilt() throws DomainException {
        Omhullende verschillendeOmhullende = new Omhullende(linkerBovenhoek, breedte, hoogte + 10);
        assertFalse(Omhullende.equals(verschillendeOmhullende));
    }

    @Test
    public void equals_moet_false_teruggeven_als_parameter_null(){
        assertFalse(Omhullende.equals(null));
    }
}