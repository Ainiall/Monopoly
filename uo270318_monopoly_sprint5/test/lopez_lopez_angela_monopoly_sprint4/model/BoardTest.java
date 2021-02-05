package lopez_lopez_angela_monopoly_sprint4.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lopez_lopez_angela_monopoly_sprint5.model.Board;
import lopez_lopez_angela_monopoly_sprint5.model.Player;
import lopez_lopez_angela_monopoly_sprint5.model.square.GoSquare;
import lopez_lopez_angela_monopoly_sprint5.model.square.Square;
import uo270318.mp.tareaS12.collections_iterators.generics.model.ArrayList;
import uo270318.mp.tareaS12.collections_iterators.generics.model.List;

public class BoardTest {
    Board b;
    List<Square> s;
    List<Square> snull;
    List<Player> p;
 
    @Before
    public void setUp() throws Exception {
	b = new Board();
	s = new ArrayList<Square>();
	for (BoardSquares pos : BoardSquares.values()) {
	    s.add(new GoSquare(pos.name(), pos.ordinal() + 1));
	}
	snull = new ArrayList<Square>();
	snull.add(null);
	snull.add(null);
	snull.add(null);
    }

    @Test
    public void testGetNthSquare() {
	// Casilla valida
	b.addSquares(s);
	assertEquals("FOUR", b.getNthSquare(3).getName());
	assertEquals(1, b.getNthSquare(0).getNumber());
	// Casilla invalida
	try {
	    b.getNthSquare(17);
	    fail("It should throw and exception");
	} catch (IllegalStateException iae) {
	    assertEquals("List can't contain invalid object/position.", iae.getMessage());
	}
    }

    @Test
    public void testAddSquares() {
	// Lista valida
	b.addSquares(s);
	assertEquals(b.getSquareList(), s);
	// Lista invalida
	try {
	    b.addSquares(snull);
	    fail("It should throw and exception");
	} catch (IllegalStateException iae) {
	    assertEquals("Invalid list", iae.getMessage());
	}
    }
}
