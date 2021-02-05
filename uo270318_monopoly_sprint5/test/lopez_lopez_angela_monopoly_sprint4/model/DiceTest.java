package lopez_lopez_angela_monopoly_sprint4.model;

import static org.junit.Assert.*;

import org.junit.Test;

import lopez_lopez_angela_monopoly_sprint5.model.Dice;

public class DiceTest {
int total;
    @Test
    public void testRoll() {
	Dice d = new Dice();
	for (int i = 0; i <= 1000; i++) {
	    int n = d.roll();
	    if(n>0 && n<7) {
		total = i;
	    }
	    assertNotEquals(7, n);
	    assertNotEquals(0, n);
	}
	assertEquals(1000,total);
    }

}
