package lopez_lopez_angela_monopoly_sprint5.model.square;

import lopez_lopez_angela_monopoly_sprint5.model.Player;

/**
 * <p>
 * Titulo: Clase GoSquare
 * </p>
 * <p>
 * Descripcion: Clase que simula una casilla de inicio.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class GoSquare extends Square {

    /**
     * Constructor con parametros
     * 
     * @param name   Nombre de la casilla
     * @param number Posicion de la casilla
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    public GoSquare(String name, int number) {
	super(name, number);
    }

    /**
     * Metodo que imprime una cadena de caracteres con la informacion de la
     * casilla.
     */
    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();
	str.append("GO");
	return str.toString();
    }

    /**
     * Metodo que implementa una accion correspondiente con el tipo de casilla.
     * 
     * @param player Jugador actual
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    @Override
    protected void doAction(Player player) {
	super.getCp().nextSquare(player.getName(), toString());
    }
}
