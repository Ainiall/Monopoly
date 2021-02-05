package lopez_lopez_angela_monopoly_sprint5.interactor;

import lopez_lopez_angela_monopoly_sprint5.model.Player;
import lopez_lopez_angela_monopoly_sprint5.model.square.PropertySquare;
/**
 * <p>
 * Titulo: Clase PlayerInteractor
 * </p>
 * <p>
 * Descripcion: Interfaz que controla metodos automaticos/no automaticos.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public interface PlayerInteractor {

    /**
     * Prompts the user to roll the dice. The execution will wait for the user
     * to do some implementation specific action to indicate the dice throw.
     */
    void askToRollTheDice();

    /**
     * Prompts the user with info about his available money and the property to
     * buy and then waits for the user to do some implementation specific action
     * to indicate Yes o No.
     */
    boolean doYouWantToBuy(Player p, PropertySquare ps);
}
