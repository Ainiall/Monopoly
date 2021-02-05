package lopez_lopez_angela_monopoly_sprint5.model;



import lopez_lopez_angela_monopoly_sprint5.model.square.Square;
import lopez_lopez_angela_monopoly_sprint5.util.Utils;
import uo270318.mp.tareaS12.collections_iterators.generics.model.ArrayList;
import uo270318.mp.tareaS12.collections_iterators.generics.model.List;
/**
 * <p>
 * Titulo: Clase Board
 * </p>
 * <p>
 * Descripcion: Clase que simula un tablero de Monopoly.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class Board {

    private List<Square> listSquares = new ArrayList<Square>();

    /**
     * Metodo que devuelve la casilla que se encuetra en la posicion que se le
     * pasa como parametro.
     * 
     * @param pos Posicion de la casilla.
     * @return Casilla de la posicion seleccionada.
     * @throws IllegalArgumentException si la posicion a buscar esta fuera de
     *                                  rango
     */
    public Square getNthSquare(int pos) {
	Utils.checkListPositionObject(listSquares, pos);
	return listSquares.get(pos);
    }

    /**
     * Metodo que inserta nuevas casillas al tablero
     * 
     * @param list Lista de casillas a insertar
     * @return Lista con las casillas del tablero
     * @throws IllegalArgumentException si la lista esta vacia
     */
    public Board addSquares(List<Square> list) {
	Utils.checkList(list);
	listSquares = new ArrayList<Square>(list);
	return this;
    }

    /**
     * Metodo auxiliar que devuelve la lista de casillas del tablero.
     * 
     * @return listSquares lista con las casillas.
     */
    public List<Square> getSquareList() {
	return listSquares;
    }
}
