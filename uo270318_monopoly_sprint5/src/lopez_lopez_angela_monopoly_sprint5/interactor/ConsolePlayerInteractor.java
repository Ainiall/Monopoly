package lopez_lopez_angela_monopoly_sprint5.interactor;

import java.util.Scanner;

import lopez_lopez_angela_monopoly_sprint5.model.Player;
import lopez_lopez_angela_monopoly_sprint5.model.square.PropertySquare;

/**
 * <p>
 * Titulo: Clase PlayerInteractor
 * </p>
 * <p>
 * Descripcion: Clase que controla metodos que requieren interaccion con el
 * usuario.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class ConsolePlayerInteractor implements PlayerInteractor {

    /**
     * Metodo que pide al usuario que lance los dados.
     */
    @SuppressWarnings("resource")
    @Override
    public void askToRollTheDice() {
	System.out.print("Press any key to roll the dice......");
	new Scanner(System.in).nextLine();

    }

    /**
     * Metodo que pregunta al usuario si quiere comprar la casilla.
     */
    @Override
    public boolean doYouWantToBuy(Player p, PropertySquare ps) {
	System.out.println("Do you want to buy " + ps.getName() + "?");
	@SuppressWarnings("resource")
	String answer = new Scanner(System.in).next().toUpperCase();
	return (answer.equals("Y") || answer.equals("YES"));
    }

}
