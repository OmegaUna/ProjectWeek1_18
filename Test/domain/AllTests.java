package domain;
import domain.Game.SpelerTest;
import domain.shapes.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PuntTest.class, SpelerTest.class, CirkelTest.class, LijnstukTest.class, OmhullendeTest.class})
public class AllTests {

}