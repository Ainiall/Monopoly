package lopez_lopez_angela_monopoly_sprint5.ui;

import lopez_lopez_angela_monopoly_sprint5.exceptions.BoardException;
import lopez_lopez_angela_monopoly_sprint5.exceptions.GameException;
import lopez_lopez_angela_monopoly_sprint5.exceptions.UserInterfaceException;
import lopez_lopez_angela_monopoly_sprint5.interactor.AutomaticPlayerInteractor;
import lopez_lopez_angela_monopoly_sprint5.interactor.ConsolePlayerInteractor;
import lopez_lopez_angela_monopoly_sprint5.interactor.PlayerInteractor;
import lopez_lopez_angela_monopoly_sprint5.model.Board;
import lopez_lopez_angela_monopoly_sprint5.model.Player;
import lopez_lopez_angela_monopoly_sprint5.model.square.Square;
import lopez_lopez_angela_monopoly_sprint5.parser.SquareParser;
import lopez_lopez_angela_monopoly_sprint5.presenter.GamePresenter;
import lopez_lopez_angela_monopoly_sprint5.service.Game;
import lopez_lopez_angela_monopoly_sprint5.util.Utils;
import lopez_lopez_angela_monopoly_sprint5.util.console.Console;
import lopez_lopez_angela_monopoly_sprint5.util.file.FileUtil;
import uo270318.mp.tareaS12.collections_iterators.generics.model.ArrayList;
import uo270318.mp.tareaS12.collections_iterators.generics.model.List;

/**
 * <p>
 * Titulo: Clase UserInterface
 * </p>
 * <p>
 * Descripcion: Clase que controla la interfaz del usuario.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class UserInterface {
    private static final char EXIT = 'e';

    private Menu menu = new Menu();
    private Game game = new Game();
    private Board board;
    private List<Player> players = new ArrayList<Player>();
    private List<PlayerInteractor> interactor = new ArrayList<PlayerInteractor>();
    private GamePresenter gp = Main.getGp();

    /**
     * Muestra el menu
     */
    public void run() {
	char option = EXIT;
	do {
	    menu.show();
	    option = menu.readOption();
	    try {
		processOption(option);
	    } catch (UserInterfaceException | GameException e) {
		handler(e);
	    } catch (BoardException e) {
		handler(e);
	    }

	} while (option != EXIT);
    }

    /**
     * Procesa la opcion seleccionada.
     * 
     * @param option Opcion
     * @throws UserInterfaceException Si el usuario selecciona una opcion
     *                                incorrecta
     * @throws GameException          Si se produce un error de usuario
     * @throws BoardException         Si el tablero escrito no existe
     */
    private void processOption(char option)
	    throws UserInterfaceException, GameException, BoardException {
	if (option == EXIT) {
	    return;
	} else if (option == 'y' || option == 'Y') {
	    newPlayer();
	} else if (option == 'd' || option == 'D') {
	    delPlayer();
	} else if (option == 'b' || option == 'B') {
	    newBoard();
	} else if (option == 'p' || option == 'P') {
	    letsPlay();
	} else {
	    throw new UserInterfaceException("Invalid option");
	}
    }


    private void newPlayer() throws UserInterfaceException, GameException {
	String playerName = Console.readString("Player name");
	Utils.checkString(playerName);
	checkRepeatedPlayerName(playerName);
	String playerInteractor = Console
		.readString("Player Interactor (A- automatic  or C- console) ");
	if (playerInteractor.equals("a") || playerInteractor.equals("A")) {
	    players.add(new Player(playerName));
	    interactor.add(new AutomaticPlayerInteractor());
	} else if (playerInteractor.equals("c")
		|| playerInteractor.equals("C")) {
	    players.add(new Player(playerName));
	    interactor.add(new ConsolePlayerInteractor());
	} else {
	    throw new UserInterfaceException("Invalid option.");
	}
    }

    private void checkRepeatedPlayerName(String playerName)
	    throws GameException {
	for (int i = 0; i < players.size(); i++) {
	    if (players.get(i).getName().equals(playerName)) {
		throw new GameException(
			"Can't create a player that already exist.");
	    }
	}

    }

    private void delPlayer() throws UserInterfaceException, GameException {
	if (!players.isEmpty()) {
	    String playerName = Console.readString("Player name: ");
	    Utils.checkString(playerName);
	    for (int i = 0; i < players.size(); i++) {
		if (players.get(i).getName().equals(playerName)) {
		    players.remove(i);
		    interactor.remove(i);
		}
	    }
	} else {
	    throw new GameException("Can't delete a non existing player");
	}
    }

    private void newBoard()
	    throws UserInterfaceException, GameException, BoardException {
	String boardName = Console.readString("Board name ");
	List<Square> squares = new SquareParser()
		.parse(FileUtil.readLines(boardName));
	board = new Board().addSquares(squares);

    }

    private void letsPlay() throws UserInterfaceException {
	if (players.isEmpty() || interactor.isEmpty()
		|| interactor.size() != players.size()) {
	    throw new IllegalStateException(
		    "Can't play without players/interactors");
	} else if (board == null) {
	    throw new IllegalStateException("Can't play without board");
	}
	game = new Game();
	game.addBoard(board);
	game.addPlayers(players);
	game.addInteractors(interactor);
	game.addGamePresenter(gp);
	game.play();
    }

    /**
     * Manejador por defecto que informa al usuario sobre el error ocurrido
     * 
     * @param e Excepcion comprobada
     */
    private void handler(Exception e) {
	gp.userHandler(e.getMessage());
    }

}
