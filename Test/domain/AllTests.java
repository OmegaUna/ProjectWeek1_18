package domain;
import domain.Game.SpelerTest;
import domain.shapes.CircleTest;
import domain.shapes.LijnStuk;
import domain.shapes.LijnstukTest;
import domain.shapes.PuntTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import java.util.function.BinaryOperator;

@RunWith(Suite.class)
@SuiteClasses({ PuntTest.class, SpelerTest.class, CircleTest.class, LijnstukTest.class, BoxAroundTest.class})
public class AllTests {

}