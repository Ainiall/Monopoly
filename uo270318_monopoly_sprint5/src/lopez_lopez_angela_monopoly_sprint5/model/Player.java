package lopez_lopez_angela_monopoly_sprint5.model;

import lopez_lopez_angela_monopoly_sprint5.exceptions.GameException;
import lopez_lopez_angela_monopoly_sprint5.model.square.GoSquare;
import lopez_lopez_angela_monopoly_sprint5.model.square.PropertySquare;
import lopez_lopez_angela_monopoly_sprint5.model.square.Square;
import lopez_lopez_angela_monopoly_sprint5.model.square.TaxSquare;
import lopez_lopez_angela_monopoly_sprint5.presenter.ColoredConsolePresenter;
import lopez_lopez_angela_monopoly_sprint5.presenter.GamePresenter;
import lopez_lopez_angela_monopoly_sprint5.util.Utils;
import uo270318.mp.tareaS12.collections_iterators.generics.model.ArrayList;
import uo270318.mp.tareaS12.collections_iterators.generics.model.List;

/**
 * <p>
 * Titulo: Clase Player
 * </p>
 * <p>
 * Descripcion: Clase que simula un jugador.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class Player {
    /**
     * Atributos
     */
    private String name;
    private double money;
    private Square squarePos;
    private List<PropertySquare> properties;
    private boolean bankrupt = false;
    private GamePresenter cp= new ColoredConsolePresenter();

    /**
     * Constantes
     */
    private static final double DEFAULT = 1500.00;
    private static final double GO = 200.00;

    /**
     * Constructor con parametro
     * 
     * @param name Nombre
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    public Player(String name){
	setName(name);
	setMoney(DEFAULT);
	setSquare(new GoSquare("GO", 1));
	this.properties = new ArrayList<PropertySquare>();
    }

    /**
     * Metodo que asigna el nombre al jugador.
     * 
     * @param name Nombre del jugador
     * @throws GameException 
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    private void setName(String name){
	Utils.checkString(name);
	this.name = name;
    }

    /**
     * Metodo que asigna dinero al jugador.
     * 
     * @param money Dinero del jugador
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    //publico para test
    public void setMoney(double money) {
	Utils.checkAmount(money);
	this.money = money;
    }

    /**
     * Metodo que asigna una casilla al jugador.
     * 
     * @param pos Posicion del jugador en el tablero
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    private void setSquare(Square pos) {
	Utils.checkObject(pos);
	this.squarePos = pos;
    }

    /**
     * Metodo que devuelve el nombre del jugador.
     * 
     * @return name Nombre del jugador
     */
    public String getName() {
	return name;
    }

    /**
     * Metodo que devuelve el dinero del jugador.
     * 
     * @return money Dinero del jugador
     */
    public double getMoney() {
	return money;
    }

    /**
     * Metodo que devuelve la posicion del jugador.
     * 
     * @return squarePos Posicion del jugador
     */
    public int getSquare() {
	return squarePos.getNumber()-1;
    }

    /**
     * Metodo que devuelve una lista con las propiedades del jugador.
     * 
     * @return properties Propiedades del jugador.
     */
    //publico para test
    public List<PropertySquare> getProperties() {
	return properties;
    }

    /**
     * Metodo que mueve al jugador a una nueva casilla que se le pasa como
     * parametro.
     * 
     * @param square Casilla a la que se dirige el jugador.
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    public void goTo(Square square) {
	Utils.checkObject(square);
	setSquare(square);
	square.landedOn(this);
    }

    /**
     * Metodo que agita la cubilete para lanzar los dados. Devuelve el resultado
     * total obtenido con la tirada.
     * 
     * @param cup Cubilete
     * @return puntuacion total obtenida
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    public int throwDices(Cup cup) {
	Utils.checkObject(cup);
	cup.shakeCup();
	return cup.getTotalScore();
    }

    /**
     * Metodo que suma una cantidad constante de dinero cada vez que se pasa por
     * la casilla inicial del tablero.
     */
    public void passesGo() {
	addMoney(GO);
    }

    /**
     * Metodo que paga el alquiler de una casilla que tiene dueño, siempre que
     * este sea distinto al jugador actual.
     * 
     * @param s Casilla de propiedades
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    public void payRent(Square s) {
	Utils.checkObject(s);
	if (this != ((PropertySquare) s).getOwner()) {
	    takeMoneyAway(((PropertySquare) s).getRentingPrice());
	    if (isBankrupt()) {
		payDebts();
	    } else if (((PropertySquare) s).getOwner() != null) {
		((PropertySquare) s).getOwner()
			.addMoney(((PropertySquare) s).getRentingPrice());
	    }
	}
    }

    /**
     * Metodo que paga los impuestos de la casilla.
     * 
     * @param s Casilla de impuestos
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    public void payTax(Square s) {
	Utils.checkObject(s);
	takeMoneyAway(((TaxSquare) s).getTaxPrice());
	if (isBankrupt()) {
	    this.setMoney(0.0);
	}
    }

    /**
     * Metodo que compra una casilla en venta.
     * 
     * @param s Casilla de propiedades
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    //publico para test
    public void buyProperty(Square s) {
	Utils.checkObject(s);
	takeMoneyAway(((PropertySquare) s).getBuyingPrice());
	if (!isBankrupt()) {
	    properties.add((PropertySquare) s);
	    ((PropertySquare) s).setOwner(this);
	}
    }

    /**
     * Metodo que quita dinero al jugador.
     * 
     * @param amount Cantidad de dinero a retirar
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    private void takeMoneyAway(double amount) {
	Utils.checkAmount(amount);
	if (amount > getMoney()) {
	    liquidate();
	} else {
	    this.setMoney(getMoney() - amount);
	}
    }

    /**
     * Metodo que aumenta el dinero del jugador en su cantidad actual y la que
     * se le pasa como parametro.
     * 
     * @param amount Dinero a insertar.
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    private void addMoney(double amount) {
	Utils.checkAmount(amount);
	setMoney(getMoney() + amount);
    }

    /**
     * Metodo que liquida los bienes del jugador cuando este intenta pagar una
     * cantidad superior a la que tiene. Por ello se declara en bancarrota.
     */
    private void liquidate() {
	setBankrupt(true);
	double liquidation_price = 0.0;
	if (!this.properties.isEmpty()) {
	    for (PropertySquare ps : properties) {
		liquidation_price += ps.getBuyingPrice() / 2;
		ps.setOwner(null);
	    }
	    properties = null;
	}
	this.addMoney(liquidation_price);
	
	cp.playerGameOver(this.getName());
    }

    /**
     * Metodo que paga las deudas del jugador tras declararse en bancarrota.
     * 
     * @param s Casilla que ha generado la deuda
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    private void payDebts() {
	if (((PropertySquare) squarePos).getOwner()==null) {
	    this.setMoney(0.0);
	} else if (getMoney() > ((PropertySquare) squarePos)
		.getRentingPrice()) {
	    ((PropertySquare) squarePos).getOwner()
		    .addMoney(((PropertySquare) squarePos).getRentingPrice());
	    this.setMoney(0.0);
	} else {
	    ((PropertySquare) squarePos).getOwner().addMoney(getMoney());
	    this.setMoney(0.0);
	}
    }

    /**
     * Metodo que asigna si el jugador esta en bancarrota.
     * 
     * @param bankrupt Bancarrota
     */
    private void setBankrupt(boolean bankrupt) {
	this.bankrupt = bankrupt;
    }

    /**
     * Metodo que indica si el jugador esta en bancarrota
     * 
     * @return bankrupt true si esta en bancarrota, false si no lo esta
     */
    public boolean isBankrupt() {
	return bankrupt;
    }

    /**
     * Metodo que devuelve una cadena de caracteres con la informacion del
     * jugador.
     */
    public String toString() {
	StringBuilder str = new StringBuilder();
	str.append("Player NAME= ").append(getName()).append(", at square ")
		.append(getSquare()).append(" ,isBankrupt = ")
		.append(isBankrupt()).append(", money = ").append(getMoney())
		.append(", properties = ").append(getPropertiesName());
	return str.toString();
    }

    /**
     * Metodo auxiliar que devuelve una cadena con el nombre de las propiedades
     * del jugador.
     * 
     * @return cadena con el nombre de las propiedades, separadas por una coma.
     */
    private String getPropertiesName() {
	StringBuilder str = new StringBuilder();
	for (int i = 0; i < properties.size(); i++) {
	    if (i == properties.size() - 1) {
		str.append(properties.get(i).getName());
	    } else {
		str.append(properties.get(i).getName()).append(",");
	    }
	}
	return str.toString();
    }

}
