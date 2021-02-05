package lopez_lopez_angela_monopoly_sprint5.presenter;

import lopez_lopez_angela_monopoly_sprint5.util.Logger;
import lopez_lopez_angela_monopoly_sprint5.util.console.Console;
/**
 * <p>
 * Titulo: Clase ColoredConsolePresenter
 * </p>
 * <p>
 * Descripcion: Clase que maneja la salida por consola usando colores.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class ColoredConsolePresenter implements GamePresenter {
    int n = 1;
    public static final String GREEN = "\033[032m"; // GREEN
    public static final String BLUE = "\033[034m"; // BLUE

    @Override
    public void gameInitialized() {
	System.out.println(BLUE + "Welcome to Monopoly Game");

    }

    @Override
    public void nextPlayer(String playerName, String square) {
	System.out.println(GREEN + n + " " + playerName + BLUE
		+ " stands on square " + GREEN + square + BLUE);
	n++;

    }

    @Override
    public void diceRolled(int value) {
	System.out.println(GREEN + value + BLUE);

    }

    @Override
    public void nextSquare(String playerName, String squareInfo) {
	System.out.println(GREEN + playerName + BLUE + " lands on " + GREEN
		+ squareInfo + BLUE);

    }

    @Override
    public void playerGameOver(String playerName) {
	System.out.println(GREEN + playerName + BLUE + " goes bankrupt.");

    }

    @Override
    public void playerBuys(String playerName, String squareName) {
	System.out.println(BLUE + "Player " + GREEN + playerName + BLUE
		+ " mbuys " + GREEN + squareName + BLUE);

    }

    @Override
    public void gameFinished(String winnerPlayerName) {
	System.out.println(BLUE + "End of game. And the winner is " + GREEN
		+ winnerPlayerName + BLUE);

    }

    @Override
    public void playerStatus(String playerName, double wealth) {
	System.out.println(BLUE + "Player " + GREEN + playerName + BLUE
		+ ": His net worth is " + GREEN + wealth + BLUE);

    }

    @Override
    public void nextRound(int round) {
	System.out.println(BLUE + "Round " + GREEN + round + BLUE);
	n = 1;
    }

    @Override
    public void defaultHanlder(String str) {
	Console.println(BLUE
		+ "Due to some technical issues, the program can't continue.");
	Console.println(BLUE + "Please contact our technical support.");
	Logger.log("\033[31m" + str + BLUE);

    }

    @Override
    public void userHandler(String str) {
	Console.println(BLUE + "An error has occurred:");
	Console.println(GREEN + str);
	Console.println(BLUE + "Please try again: ");
    }
}
