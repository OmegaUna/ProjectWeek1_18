package domain.shapes;

import org.junit.Before;
import org.junit.Test;

import domain.exceptions.*;

import static org.junit.Assert.*;

public class CircleTest {

    private int geldigeStraal, geldigeStraal2;
    private Punt geldigMiddelpunt, geldigMiddelpunt2;
    private Circle circle, circle2;

    @Before
    public void setUp() {
        geldigeStraal = 20;
        geldigMiddelpunt = new Punt(50,50);
        geldigeStraal2 = 15;
        geldigMiddelpunt2 = new Punt(40,40);
    }

    @Test
    public void circle_maakt_circleMetGeldigMiddelpuntenStraal() throws DomainException {
        circle = new Circle(geldigMiddelpunt, geldigeStraal);
        assertEquals(geldigeStraal, circle.getRadius());
        assertEquals(geldigMiddelpunt, circle.getCenter());
    }

    @Test (expected = DomainException.class)
    public void circle_met_circleMetMiddelpuntNULL_geeft_Exception() throws DomainException {
        circle = new Circle(null, geldigeStraal);
    }

    @Test (expected = DomainException.class)
    public void circle_met_circleMetStraalKleinerDan0_geeft_Exception() throws DomainException {
        circle = new Circle(geldigMiddelpunt, -3);
    }

    @Test (expected = DomainException.class)
    public void circle_met_circleMetStraalGelijkAan0_geeft_Exception() throws DomainException {
        circle = new Circle(geldigMiddelpunt, 0);
    }

    @Test
    public void equals_met_2CirkelsZelfdeMiddelpuntEnStraal_is_True() throws DomainException {
        circle = new Circle(geldigMiddelpunt, geldigeStraal);
        circle2 = new Circle(geldigMiddelpunt, geldigeStraal);
        assertTrue(circle.equals(circle2));
    }

    @Test
    public void equals_met_2CirkelsWaarvanéénNULLis_is_False() throws DomainException {
        circle = new Circle(geldigMiddelpunt, geldigeStraal);
        assertFalse(circle.equals(null));
    }

    @Test
    public void equals_met_2CirkelsZelfdeStraalVerschillendMiddelpunt_is_False() throws DomainException {
        circle = new Circle(geldigMiddelpunt, geldigeStraal);
        circle2 = new Circle(geldigMiddelpunt2, geldigeStraal);
        assertFalse(circle.equals(circle2));
    }

    @Test
    public void equals_met_2CirkelsZelfdeMiddelpuntVerschillendStraal_is_False() throws DomainException {
        circle = new Circle(geldigMiddelpunt, geldigeStraal);
        circle2 = new Circle(geldigMiddelpunt, geldigeStraal2);
        assertFalse(circle.equals(circle2));
    }
}
