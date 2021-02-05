package lopez_lopez_angela_monopoly_sprint5.model;

import lopez_lopez_angela_monopoly_sprint5.util.Utils;
import uo270318.mp.tareaS12.collections_iterators.generics.model.ArrayList;

/**
 * <p>
 * Titulo: Clase Cup
 * </p>
 * <p>
 * Descripcion: Clase que simula un cubo usado para tirar dados.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class Cup {
    // Lista de dados, se necesitan 2
    private ArrayList<Dice> dice = new ArrayList<Dice>();
    private int totalScore; // suma de los 2 dados

    /**
     * Constructor del cubilete. Se le pasa como parametros el numero de dados
     * con los que se juega la partida. Se necesitan 2 dados para poder jugar.
     * 
     * @param numDices Numero de dados con los que se juega la partida.
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    public Cup(int numDices) {
	Utils.checkNumber(numDices);
	if (numDices < 2) {
	    throw new IllegalArgumentException(
		    "2 dices needed in order to play!");
	}
	for (int i = 0; i < numDices; i++) {
	    dice.add(new Dice());
	}
    }

    /**
     * Metodo que devuelve la puntuacion total obtenida
     * 
     * @return totalScore puntuacion total
     */
    protected int getTotalScore() {
	return totalScore;
    }

    public int maxScore() {
	return Math.multiplyExact(6, dice.size());
    }

    /**
     * Metodo que agita el cubilete para agitar ambos dados. Esto invoca al
     * metodo roll() que devuelve la puntuacion obtenida por cada dado. Se
     * actualiza la puntuacion total con la suma de las puntuaciones de ambos
     * dados.
     */
    protected void shakeCup() {
	totalScore = 0;
	for (Dice d : dice) {
	    totalScore = totalScore + d.roll();
	}
    }
}
