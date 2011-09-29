package snake.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CellArrayTest.class, CellTest.class, MoveSnakeTest.class })
public class AllTests {

}
