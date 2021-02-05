package lopez_lopez_angela_monopoly_sprint5.model.square;


/**
 * <p>
 * Titulo: Clase LotSquare
 * </p>
 * <p>
 * Descripcion: Clase que simula una casilla Lot.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class LotSquare extends PropertySquare {

    /**
     * Constructor con parametros
     * 
     * @param name         Nombre de la casilla
     * @param position     Posicion de la casilla
     * @param buyingPrice  Precio de compra
     * @param rentingPrice Precio alquiler
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    public LotSquare(String name, int position, double buyingPrice,
	    double rentingPrice) {
	super(name, position, buyingPrice, rentingPrice);
    }

}
