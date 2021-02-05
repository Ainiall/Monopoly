package lopez_lopez_angela_monopoly_sprint5.model.square;


/**
 * <p>
 * Titulo: Clase RailroadSquare
 * </p>
 * <p>
 * Descripcion: Clase que simula una casilla de estaciones.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class RailroadSquare extends PropertySquare {

    /**
     * Constructor con parametros
     * 
     * @param name Nombre de la casilla
     * @param position Posicion de la casilla
     * @param buyingPrice Precio de compra
     * @param rentingPrice Precio de venta
     * 
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    public RailroadSquare(String name, int position, double buyingPrice,
	    double rentingPrice){
	super(name, position, buyingPrice, rentingPrice);

    }

}
