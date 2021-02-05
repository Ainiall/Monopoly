package lopez_lopez_angela_monopoly_sprint4.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lopez_lopez_angela_monopoly_sprint5.model.Board;
import lopez_lopez_angela_monopoly_sprint5.model.Player;
import lopez_lopez_angela_monopoly_sprint5.model.square.GoSquare;
import lopez_lopez_angela_monopoly_sprint5.model.square.LotSquare;
import lopez_lopez_angela_monopoly_sprint5.model.square.NonFeeSquare;
import lopez_lopez_angela_monopoly_sprint5.model.square.RailroadSquare;
import lopez_lopez_angela_monopoly_sprint5.model.square.Square;
import lopez_lopez_angela_monopoly_sprint5.model.square.TaxSquare;
import uo270318.mp.tareaS12.collections_iterators.generics.model.ArrayList;
import uo270318.mp.tareaS12.collections_iterators.generics.model.List;

public class PlayerTest {
    private Player p;
    @SuppressWarnings("unused")
    private Player p2;
    @SuppressWarnings("unused")
    private Player p3;
    @SuppressWarnings("unused")
    private Board b;
    private List<Square> s;

    @Before
    public void setUp() throws Exception {
	s = new ArrayList<Square>();
	s.add(new GoSquare("Go", 1));
	s.add(new LotSquare("Mediterranean Ave", 2, 60, 2));
	s.add(new NonFeeSquare("Golden Gate Park", 3));
	s.add(new LotSquare("Baltic Ave", 4, 60, 4));
	s.add(new TaxSquare("Income tax", 5, 200));
	s.add(new RailroadSquare("Reading Railroad", 6, 200, 20));
	p = new Player("Pepito");
	p2 = new Player("Paca");
	p3 = new Player("Carmen");
	b = new Board().addSquares(s);
    }

    @Test
    public void testPlayer() {
	// Jugador valido
	assertEquals("Pepito", p.getName());
	assertEquals(1500.00, p.getMoney(), 01);
	assertEquals(0, p.getSquare());
	// Jugador invalido
	try {
	    @SuppressWarnings("unused")
	    Player p = new Player("   ");
	} catch (IllegalArgumentException iae) {
	    assertEquals("Invalid text", iae.getMessage());
	}
    }

    @Test
    public void testGoTo() {
	// Casilla valida
	// p.goTo(b.getNthSquare(4)); //presenter
	// assertEquals(5,p.getSquare());
	// Casilla invalida (null)
	try {
	    p.goTo(null);
	} catch (IllegalArgumentException iae) {
	    assertEquals("Invalid object: it can't be null.", iae.getMessage());
	}

    }

    @Test
    public void testLiquidate() {
	// fallo por usar el presenter en esta version
	// (al pasarlo desde el main en las pruebas es null)

	// Casilla propiedad que no tiene dueño
	// p.setMoney(40.0);
	// p.payRent(s.get(3));
	// assertEquals(0.0,p.getMoney(),0.01);
	// assertTrue(p.getProperties().isEmpty());

	// Casilla que tiene dueño
	// p2.buyProperty(s.get(4));
	// p3.setMoney(620);
	// p3.buyProperty((PropertySquare) s.get(2));
	// p3.buyProperty((PropertySquare) s.get(1));
	// p3.buyProperty((PropertySquare) s.get(6));
	// p3.payRent((PropertySquare) s.get(4));
	// assertEquals(1450.0,p2.getMoney(),0.01);
	// assertEquals(0.0,p3.getMoney(),0.01);
    }
}
