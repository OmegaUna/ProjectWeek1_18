package domain.shapes;

import static org.junit.Assert.*;

import domain.exceptions.DomainException;
import domain.shapes.BoxAround;
import domain.shapes.Punt;
import org.junit.Before;
import org.junit.Test;

public class BoxAroundTest {

    private Punt linkerBovenhoek;
    private int breedte, hoogte;
    private BoxAround BoxAround;

    @Before
    public void setUp() throws DomainException {
        linkerBovenhoek = new Punt(200, 200);
        breedte = 20;
        hoogte = 40;
        BoxAround = new BoxAround(linkerBovenhoek,breedte, hoogte);
    }

    @Test
    public void BoxAround_moet_BoxAround_aanmaken_met_gegeven_linkerbovenhoek_breedte_en_hoogte() throws DomainException {
        BoxAround BoxAround = new BoxAround(linkerBovenhoek,breedte, hoogte);
        assertEquals(linkerBovenhoek, BoxAround.getLUCorner());
        assertEquals(hoogte, BoxAround.getHeight());
        assertEquals(breedte, BoxAround.getWidth());
    }

    @Test (expected = DomainException.class)
    public void BoxAround_Moet_exception_gooien_als_linkerbovenhoek_null() throws DomainException {
        new BoxAround(null, breedte, hoogte);
    }

    @Test (expected = DomainException.class)
    public void BoxAround_Moet_exception_gooien_als_breedte_kleiner_dan_0() throws DomainException {
        new BoxAround(linkerBovenhoek, -1, hoogte);
    }

    @Test (expected = DomainException.class)
    public void BoxAround_Moet_exception_gooien_als_hoogte_kleiner_dan_0() throws DomainException {
        new BoxAround(linkerBovenhoek, breedte, -1);
    }

    @Test
    public void BoxAround_Moet_BoxAround_maken_als_breedte_gelijk_aan_0() throws DomainException {
        BoxAround BoxAround = new BoxAround(linkerBovenhoek,0, hoogte);
        assertEquals(0, BoxAround.getWidth());
    }

    @Test
    public void BoxAround_Moet_BoxAround_maken_als_hoogte_gelijk_aan_0() throws DomainException {
        BoxAround BoxAround = new BoxAround(linkerBovenhoek,breedte, 0);
        assertEquals(0, BoxAround.getHeight());
    }

    @Test
    public void equals_moet_true_teruggeven_als_linkerbovenhoek_breedte_hoogte_gelijk_zijn() throws DomainException {
        BoxAround zelfdeBoxAround = new BoxAround(linkerBovenhoek,breedte, hoogte);
        assertTrue(BoxAround.equals(zelfdeBoxAround));
    }

    @Test
    public void equals_moet_false_teruggeven_als_linkerbovenhoek_verschilt() throws DomainException {
        Punt andereLinkerBovenhoek = new Punt(100,100);
        BoxAround verschillendeBoxAround = new BoxAround(andereLinkerBovenhoek, breedte, hoogte);
        assertFalse(BoxAround.equals(verschillendeBoxAround));
    }

    @Test
    public void equals_moet_false_teruggeven_als_breedte_verschilt() throws DomainException {
        BoxAround verschillendeBoxAround = new BoxAround(linkerBovenhoek, breedte + 10, hoogte);
        assertFalse(BoxAround.equals(verschillendeBoxAround));
    }

    @Test
    public void equals_moet_false_teruggeven_als_hoogte_verschilt() throws DomainException {
        BoxAround verschillendeBoxAround = new BoxAround(linkerBovenhoek, breedte, hoogte + 10);
        assertFalse(BoxAround.equals(verschillendeBoxAround));
    }

    @Test
    public void equals_moet_false_teruggeven_als_parameter_null(){
        assertFalse(BoxAround.equals(null));
    }
}