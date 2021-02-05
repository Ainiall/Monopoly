package lopez_lopez_angela_monopoly_sprint5.model.square;

import lopez_lopez_angela_monopoly_sprint5.model.Player;
import lopez_lopez_angela_monopoly_sprint5.service.Game;
import lopez_lopez_angela_monopoly_sprint5.util.Utils;

/**
 * <p>
 * Titulo: Clase PropertySquare
 * </p>
 * <p>
 * Descripcion: Clase que simula una casilla de propiedades.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class PropertySquare extends Square {

    /**
     * Atributos
     */
    private double buyingPrice;
    private double rentingPrice;
    private boolean status;
    private Player owner;

    /**
     * Constructor con parametros
     * 
     * @param name         Nombre de la casilla
     * @param position     Posicion de la casilla
     * @param buyingPrice  Precio de compra de la casilla
     * @param rentingPrice Precio de alquiler de la casilla
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    public PropertySquare(String name, int position, double buyingPrice,
	    double rentingPrice) {
	super(name, position);
	setBuyingPrice(buyingPrice);
	setRentingPrice(rentingPrice);
	setStatus(false);
    }

    /**
     * Metodo que asigna un precio de compra a una casilla
     * 
     * @param buyingPrice Precio de compra
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    protected void setBuyingPrice(double buyingPrice) {
	Utils.checkAmount(buyingPrice);
	this.buyingPrice = buyingPrice;
    }

    /**
     * Metodo que asigna un precio de alquiler a una casilla
     * 
     * @param rentingPrice Precio de alquiler
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    protected void setRentingPrice(double rentingPrice) {
	Utils.checkAmount(rentingPrice);
	this.rentingPrice = rentingPrice;
    }

    /**
     * Metodo que asgina si una casilla tiene o no propietario
     * 
     * @param status true si tiene propietario, false si no
     */
    protected void setStatus(boolean status) {
	this.status = status;
    }

    /**
     * Metodo que asigna un propietario a una casilla
     * 
     * @param p Jugador propietario de la casilla
     */
    public void setOwner(Player p) {
	if (p == null) {
	    setStatus(false);
	} else {
	    this.owner = p;
	    setStatus(true);
	}

    }

    /**
     * Metodo que devuelve el precio de compra de una casilla
     * 
     * @return buyingPrice precio de compra
     */
    public double getBuyingPrice() {
	return buyingPrice;
    }

    /**
     * Metodo que devuelve el precio de alquiler de una casilla
     * 
     * @return rentingPrice precio de alquiler
     */
    public double getRentingPrice() {
	return rentingPrice;
    }

    /**
     * Metodo que devuelve el estado de una casilla
     * 
     * @return status estado de una casilla
     */
    protected boolean getStatus() {
	return status;
    }

    /**
     * Metodo que devuelve el dueño de una casilla
     * 
     * @return owner Dueño de la casilla
     */
    public Player getOwner() {
	return owner;
    }

    /**
     * Metodo que imprime una cadena de caracteres con la informacion de la
     * casilla.
     */
    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();
	str.append(getClass().getSimpleName().toUpperCase().replaceAll("SQUARE",
		"") + " = ");
	str.append(getName());
	str.append(" POSITION = ").append(getNumber());
	if (getStatus()) {
	    str.append(" OWNER = ").append(getOwner().getName());
	} else {
	    str.append(" OWNER = Not owned");
	}
	str.append(" BUYING PRICE = ").append(getBuyingPrice());
	str.append(" RENTING PRICE = ").append(getRentingPrice());
	return str.toString();
    }

    /**
     * Metodo que implementa una accion distinta segun el tipo de casilla que
     * sea.
     * 
     * @param player Jugador actual
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    @Override
    protected void doAction(Player player) {
	Utils.checkObject(player);
	super.getCp().nextSquare(player.getName(), toString());
	tryToBuy(player);
    }

    /**
     * Metodo auxiliar que comprueba si un jugador puede y quiere comprar la
     * casilla.
     * 
     * @param p Casilla
     */
    private void tryToBuy(Player p) {
	if (!getStatus()) {
	    if (p.getMoney() > this.getBuyingPrice()) {
		for (int i = 0; i < Game.getPlayers().size(); i++) {
		    if (p.equals(Game.getPlayer(i))) {
			if (Game.getPlayerInteractor().get(i).doYouWantToBuy(p,
				this) == true) {
			    p.buyProperty(this);
			    super.getCp().playerBuys(p.getName(),
				    this.getName());

			}
		    }
		}
	    }
	} else {
	    p.payRent(this);
	}
    }
}
