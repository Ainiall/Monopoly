package lopez_lopez_angela_monopoly_sprint4.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import lopez_lopez_angela_monopoly_sprint4.service.GameTest;

@RunWith(Suite.class)
@SuiteClasses({ BoardTest.class, DiceTest.class, PlayerTest.class,
	GameTest.class })
public class AllTests {

}
