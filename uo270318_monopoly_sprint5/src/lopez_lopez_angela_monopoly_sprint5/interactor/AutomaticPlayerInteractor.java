package lopez_lopez_angela_monopoly_sprint5.interactor;

import lopez_lopez_angela_monopoly_sprint5.model.Player;
import lopez_lopez_angela_monopoly_sprint5.model.square.PropertySquare;

/**
 * <p>
 * Titulo: Clase AutomaticPlayerInteractor
 * </p>
 * <p>
 * Descripcion: Clase que manjea la interaccion con el usuario automaticamente.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class AutomaticPlayerInteractor implements PlayerInteractor {

    @Override
    public void askToRollTheDice() {
	System.out.print("Rolling the dice AUTOMATICALLY...");
    }

    @Override
    public boolean doYouWantToBuy(Player p, PropertySquare ps) {
	return true;
    }

}
