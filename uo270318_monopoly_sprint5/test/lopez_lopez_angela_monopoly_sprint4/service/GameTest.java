package lopez_lopez_angela_monopoly_sprint4.service;

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
import lopez_lopez_angela_monopoly_sprint5.model.square.UtilitySquare;
import lopez_lopez_angela_monopoly_sprint5.service.Game;
import uo270318.mp.tareaS12.collections_iterators.generics.model.ArrayList;

public class GameTest {
    private Game game = new Game();
    private Board board;
    private ArrayList<Square> s = new ArrayList<Square>();
    private ArrayList<Square> s2= new ArrayList<Square>();
    private ArrayList<Player> p = new ArrayList<Player>();
    private ArrayList<Player> p2 = new ArrayList<Player>();

    @Before
    public void setUp() throws Exception {
	s.add(new GoSquare("GO", 0));
	s.add(new LotSquare("Mediterranean Ave", 1, 60, 2));
	s.add(new NonFeeSquare("Golden Gate Park", 2));
	s.add(new LotSquare("Baltic Ave", 3, 60, 4));
	s.add(new TaxSquare("Income tax", 4, 200));
	s.add(new RailroadSquare("Reading Railroad", 5, 200, 20));
	s.add(new LotSquare("Oriental Ave", 6, 100, 6));
	s.add(new NonFeeSquare("Central Park", 7));
	s.add(new LotSquare("Vermont Ave", 8, 100, 6));
	s.add(new LotSquare("Connecticut Ave", 9, 120, 8));
	s.add(new NonFeeSquare("Tivoli Gardens", 10));
	s.add(new LotSquare("St. Charles Place", 11, 140, 10));
	s.add(new UtilitySquare("Electric Company", 12, 150, 15));
	s.add(new LotSquare("States Ave", 13, 140, 10));
	s.add(new LotSquare("Virginia Ave", 14, 160, 12));
	s.add(new RailroadSquare("Pennsylvania Railroad", 15, 200, 20));
	s.add(new LotSquare("St. James Place", 16, 180, 14));
	s.add(new NonFeeSquare("Hyde Park", 17));
	s.add(new LotSquare("Tennessee Ave", 18, 180, 14));
	s.add(new LotSquare("New York Ave", 19, 200, 16));
	s.add(new NonFeeSquare("FreeParking", 20));
	s.add(new LotSquare("Kentucky Ave", 21, 220, 18));
	s.add(new NonFeeSquare("Park G?ell", 22));
	s.add(new LotSquare("Indiana Ave", 23, 220, 18));
	s.add(new LotSquare("Illinois Ave", 24, 240, 20));
	s.add(new RailroadSquare("O Railroad", 25, 200, 20));
	s.add(new LotSquare("Atlantic Ave", 26, 260, 22));
	s.add(new LotSquare("Ventnor Ave", 27, 260, 22));
	s.add(new UtilitySquare("Water Works", 28, 150, 15));
	s.add(new LotSquare("Marvin Gardens Ave", 29, 280, 24));
	s.add(new NonFeeSquare("Griffith Park", 30));
	s.add(new LotSquare("Pacific Ave", 31, 300, 26));
	s.add(new LotSquare("North Carolina Ave", 32, 300, 26));
	s.add(new NonFeeSquare("Luxembourg Garden", 33));
	s.add(new LotSquare("Pennsylvania Ave", 34, 320, 28));
	s.add(new RailroadSquare("ShortLine", 35, 200, 20));
	s.add(new NonFeeSquare("Balboa Park", 36));
	s.add(new LotSquare("Park Place", 37, 350, 35));
	s.add(new TaxSquare("Luxury tax", 38, 100));
	s.add(new LotSquare("Boardwalk", 39, 400, 50));

	board = new Board().addSquares(s);

	p.add(new Player("Bob"));
	p.add(new Player("Alice"));
	p.add(new Player("Eve"));
	game.addPlayers(p);
    }

    @Test
    public void testAddBoard() {
	// Insertar casillas validas
	game.addBoard(board);
	// Insertar lista de casillas null
	try {
	    game.addBoard(null);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("Invalid object: it can't be null.", iae.getMessage());
	}
	// Insertar lista de casillas que contiene null
	try {
	    s2.add(new LotSquare("Pacific Ave", 31, 300, 26));
	    s2.add(null);
	    Board b = new Board().addSquares(s2);
	    game.addBoard(b);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalStateException ge) {
	    assertEquals("Invalid list", ge.getMessage());
	}
    }

    @Test
    public void testAddPlayers() {
	// Insertar jugadores validos
	game.addPlayers(p);
	// Insertar lista de jugadores null
	try {
	    game.addPlayers(null);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalStateException iae) {
	    assertEquals("Invalid list", iae.getMessage());
	}
	// Insertar lista de jugadores fuera de rango
	try {
	    p2.add(new Player("player1"));
	    game.addPlayers(p2);
	    fail("Deberia lanzar una excepcion"); 
	} catch (IllegalStateException ise) {
	    assertEquals("Allowed players: from 2 to 8", ise.getMessage());
	}
    }
    
}
