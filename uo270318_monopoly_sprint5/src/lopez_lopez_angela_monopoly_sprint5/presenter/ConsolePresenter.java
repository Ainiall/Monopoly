package lopez_lopez_angela_monopoly_sprint5.presenter;

import lopez_lopez_angela_monopoly_sprint5.util.Logger;
import lopez_lopez_angela_monopoly_sprint5.util.console.Console;
/**
 * <p>
 * Titulo: Clase ConsolePresenter
 * </p>
 * <p>
 * Descripcion: Clase que maneja la salida por consola.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class ConsolePresenter implements GamePresenter {
    int n = 1;

    @Override
    public void gameInitialized() {
	System.out.println("Welcome to Monopoly Game");

    }

    @Override
    public void nextPlayer(String playerName, String square) {
	System.out
		.println(n + " " + playerName + " stands on square " + square);
	n++;
    }

    @Override
    public void diceRolled(int value) {
	System.out.println(value);

    }

    @Override
    public void nextSquare(String playerName, String squareInfo) {
	System.out.println(playerName + " lands on " + squareInfo);

    }

    @Override
    public void playerGameOver(String playerName) {
	System.out.println(playerName + "goes bankrupt.");
    }

    @Override
    public void playerBuys(String playerName, String squareName) {
	System.out.println("Player " + playerName + " buys " + squareName);

    }

    @Override
    public void gameFinished(String winnerPlayerName) {
	System.out
		.println("End of game. And the winner is " + winnerPlayerName);

    }

    @Override
    public void playerStatus(String playerName, double wealth) {
	System.out.println(
		"Player " + playerName + ": His net worth is " + wealth);

    }

    @Override
    public void nextRound(int round) {
	System.out.println("Round " + round);
	n = 1;
    }

    @Override
    public void defaultHanlder(String str) {
	Console.println(
		"Due to some technical issues, the program can't continue.");
	Console.println("Please contact our technical support.");
	Logger.log(str);
	
    }

    @Override
    public void userHandler(String str) {
	Console.println("An error has occurred:");
	Console.println(str);
	Console.println("Please try again: ");
    }
}
