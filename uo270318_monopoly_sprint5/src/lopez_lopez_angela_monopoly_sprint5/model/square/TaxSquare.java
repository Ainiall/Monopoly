package lopez_lopez_angela_monopoly_sprint5.model.square;

import lopez_lopez_angela_monopoly_sprint5.model.Player;
import lopez_lopez_angela_monopoly_sprint5.util.Utils;

/**
 * <p>
 * Titulo: Clase TaxSquare
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
public class TaxSquare extends Square {

    private double taxPrice;

    /**
     * Constructor con parametros
     * 
     * @param name     Nombre de la casilla
     * @param number   Posicion de la casilla
     * @param taxPrice Precio del impuesto
     * 
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    public TaxSquare(String name, int number, double taxPrice) {
	super(name, number);
	setTaxPrice(taxPrice);
    }

    /**
     * Metodo que asgina un impuesto a la casilla
     * 
     * @param taxPrice Impuesto
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    private void setTaxPrice(double taxPrice) {
	Utils.checkAmount(taxPrice);
	this.taxPrice = taxPrice;
    }

    /**
     * Metodo que devuelve el impuesto de la casilla
     * 
     * @return taxPrice Impuesto
     */
    public double getTaxPrice() {
	return taxPrice;
    }

    /**
     * Metodo que imprime una cadena de caracteres con la informacion de la
     * casilla.
     */
    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();
	str.append("TAX =").append(getName());
	str.append(" POSITION = ").append(getNumber());
	str.append(" TAX PRICE = ").append(getTaxPrice());
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
	player.payTax(this);
    }
}
