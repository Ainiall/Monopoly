package lopez_lopez_angela_monopoly_sprint5.model.square;

import lopez_lopez_angela_monopoly_sprint5.model.Player;
import lopez_lopez_angela_monopoly_sprint5.presenter.GamePresenter;
import lopez_lopez_angela_monopoly_sprint5.service.Game;
import lopez_lopez_angela_monopoly_sprint5.util.Utils;
/**
 * <p>
 * Titulo: Clase Square
 * </p>
 * <p>
 * Descripcion: Clase que simula una casilla de impuestos.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public abstract class Square {
    private String name;
    private int number;

    /**
     * Constructor con parametros.
     * 
     * @param name   Nombre de la casilla
     * @param number Posicion de la casilla 
     * 
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    public Square(String name, int number){
	setName(name);
	setNumber(number);
    }

    /**
     * Metodo que asigna un numero a la casilla.
     * 
     * @param number Numero de la casilla.
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    protected void setNumber(int number) {
	Utils.checkNumber(number);
	this.number = number;
    }

    /**
     * Metodo que asigna un nombre a la casilla.
     * 
     * @param name Nombre de la casilla.
     * @throws GameException 
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    protected void setName(String name){
	Utils.checkString(name);
	this.name = name;
    }

    /**
     * Metodo que devuelve el numero de la casilla.
     * 
     * @return number Numero de la casilla.
     */
    public int getNumber() {
	return number;
    }

    /**
     * Metodo que devuelve el nombre de la casilla.
     * 
     * @return name Nombre de la casilla.
     */
    public String getName() {
	return name;
    }
    
    /**
     * Metodo que devuelve el presenter de la casilla
     * @return
     */
    protected GamePresenter getCp() {
	GamePresenter cp= Game.getGamePresenter();
        return cp;
    }

    /**
     * Metodo que actualiza la lista de jugadores cada vez que cambian de
     * casilla.
     * 
     * @param player Jugador a modificar.
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    public void landedOn(Player player) {
	Utils.checkObject(player);
	this.doAction(player);
    }

    /**
     * Metodo que implementa una accion correspondiente con el tipo de casilla.
     */
    protected abstract void doAction(Player player);

    /**
     * Metodo que imprime una cadena de caracteres con la informacion de la
     * casilla.
     */
    @Override
    public abstract String toString();
}