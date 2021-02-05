package lopez_lopez_angela_monopoly_sprint5.service;

import lopez_lopez_angela_monopoly_sprint5.interactor.PlayerInteractor;
import lopez_lopez_angela_monopoly_sprint5.model.Board;
import lopez_lopez_angela_monopoly_sprint5.model.Cup;
import lopez_lopez_angela_monopoly_sprint5.model.Player;
import lopez_lopez_angela_monopoly_sprint5.presenter.GamePresenter;
import lopez_lopez_angela_monopoly_sprint5.util.Utils;
import uo270318.mp.tareaS12.collections_iterators.generics.model.ArrayList;
import uo270318.mp.tareaS12.collections_iterators.generics.model.List;

/**
 * <p>
 * Titulo: Clase Game
 * </p>
 * <p>
 * Descripcion: Clase que simula una partida de Monopoly.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class Game {
    private Board currentBoard;
    private static List<Player> listPlayers;
    private Cup cup;
    private static List<PlayerInteractor> playerInteractor;
    private static GamePresenter cp;

    /**
     * Metodo que maneja el juego
     */
    public void play() {
	startUp();
	cp.gameInitialized();
	int round = 1;
	// RONDAS
	while (continueGame()) {
	    cp.nextRound(round);
	    // TURNOS
	    for (int j = 0; j < listPlayers.size(); j++) {
		if (continueGame()) {
		    Player player = listPlayers.get(j);
		    if (!player.isBankrupt()) {
			String squareName = currentBoard
				.getNthSquare(player.getSquare()).getName();
			cp.nextPlayer(player.getName(), squareName);
			getPlayerInteractor().get(j).askToRollTheDice();
			int score = player.throwDices(cup);
			cp.diceRolled(score);
			moveToNewPosition(player, score);
		    }
		}
	    }
	    round++;
	}
	cp.gameFinished(getWinner().getName());
    }

    /**
     * Metodo auxiliar que comprueba si se puede seguir jugando. Para ello
     * comprueba que jugadores estan en bancarrota. Cuando el numero alcanza 2
     * el juego termina.
     * 
     * @return true Si se puede seguir jugando, false si no.
     */
    private boolean continueGame() {
	int bankrupt = 0;
	for (int i = 0; i < listPlayers.size(); i++) {
	    if (listPlayers.get(i).isBankrupt()) {
		bankrupt++;
		if (bankrupt == 2) {
		    return false;
		}
	    }
	}
	return true;
    }

    /**
     * Metodo auxiliar que devuelve el ganador de la partida. Gana aquel que
     * tiene mas dinero a la hora de finalizar el juego.
     * 
     * @return winner Ganador de la partida.
     */
    private Player getWinner() {
	Player winner = listPlayers.get(0);
	for (Player player : listPlayers) {
	    if (winner.getMoney() < player.getMoney()) {
		winner = player;
	    }
	}
	return winner;
    }

    /**
     * Metodo que mueve al jugador pasado como parametro a la posicion que le
     * corresponde, segun su posicion actual y su puntuacion obtenida.
     * 
     * @param player Jugador
     * @param score  Puntuacion
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    private void moveToNewPosition(Player player, int score) {
	if (player == null || score > currentBoard.getSquareList().size()
		+ cup.maxScore()) {
	    throw new IllegalArgumentException("Ivalid movement");
	}
	int move = player.getSquare() + score;
	if (move < currentBoard.getSquareList().size()) {
	    player.goTo(currentBoard.getNthSquare(move));
	} else {
	    player.passesGo();
	    player.goTo(currentBoard
		    .getNthSquare(move - currentBoard.getSquareList().size()));
	}
    }

    /**
     * Metodo que crea y configura cada elemento del juego
     *
     * @throws IllegalArgumentException Si no cumple los parametros necesarios
     *                                  para inicial el juego.
     */
    private void startUp() {
	cup = new Cup(2); // cubilete con los 2 dados necesarios

	if (currentBoard == null || listPlayers == null) {
	    throw new IllegalArgumentException(
		    "We need a board and 2-8 players in order to play.");
	}
    }

    /**
     * Metodo que asigna al tablero aquel que se le pasa como parametro.
     * 
     * @param board Tablero a asignar.
     */
    public void addBoard(Board board) {
	Utils.checkObject(board);
	currentBoard = board;
    }

    /**
     * Metodo que inserta a la lista de jugadores aquellos que se le pasan como
     * parametro. Para ello se comprueba que el numero de jugadores este dentro
     * del rango permitido.
     * 
     * @param numPlayers Lista de jugadores
     */
    public void addPlayers(List<Player> numPlayers) {
	Utils.checkList(numPlayers);
	if (numPlayers.size() < 2 || numPlayers.size() > 8) {
	    throw new IllegalStateException("Allowed players: from 2 to 8");
	} else {
	    listPlayers = new ArrayList<Player>(numPlayers);

	}
    }

    /**
     * Metodo que inserta a la lista de interactors aquellos que se le pasan
     * como parametro. para ello se comprueba que la lista sea valida.
     * 
     * @param createInteractor Lista de interactors
     */
    public void addInteractors(List<PlayerInteractor> createInteractor) {
	Utils.checkList(createInteractor);
	Game.playerInteractor = createInteractor;
    }

    /**
     * Metodo que asigna al presentador aquel que se le pasa como parametro.
     * 
     * @param consolePresenter Presentador
     */
    public void addGamePresenter(GamePresenter consolePresenter) {
	Utils.checkObject(consolePresenter);
	cp = consolePresenter;

    }

    /**
     * Metodo auxiliar que devuelve el jugador de una posicion concreta que se
     * le pasa como parametro.
     * 
     * @param pos Posicion
     * @return Player de la posicion indicada
     */
    public static Player getPlayer(int pos) {
	Utils.checkListPositionObject(listPlayers, pos);
	return listPlayers.get(pos);
    }

    /**
     * Metodo auxiliar que devuelve la lista de jugadores.
     * 
     * @return Lista de jugadores
     */
    public static List<PlayerInteractor> getPlayerInteractor() {
	//return playerInteractor;
	return new ArrayList<>(playerInteractor);
    }
    
    /**
     * Metodo auxiliar que devuelve la lista de jugadores.
     * @return Lista de jugadores
     */
    public static List<Player> getPlayers() {
	//return listPlayers;
	return new ArrayList<>(listPlayers);
    }

    /**
     * Metodo auxiliar que devuelve el presentador del juego.
     * @return cp GamePresenter
     */
    public static GamePresenter getGamePresenter() {
	return cp;
    }
}
