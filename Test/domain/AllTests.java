package domain;
import domain.game.HintLetter;
import domain.game.HintLetterTest;
import domain.game.HintWoordTest;
import domain.game.SpelerTest;
import domain.shapes.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PuntTest.class, SpelerTest.class, CirkelTest.class, LijnstukTest.class, OmhullendeTest.class, HintLetterTest.class,HintWoordTest.class})
public class AllTests {

}