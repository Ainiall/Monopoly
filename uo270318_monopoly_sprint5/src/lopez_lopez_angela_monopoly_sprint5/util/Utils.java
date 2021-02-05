package lopez_lopez_angela_monopoly_sprint5.util;

import lopez_lopez_angela_monopoly_sprint5.exceptions.GameException;
import uo270318.mp.tareaS12.collections_iterators.generics.model.List;

/**
 * <p>
 * Titulo: Clase Utils
 * </p>
 * <p>
 * Descripcion: Clase que contiene metodos de verificacion y cadenas de texto
 * comunes.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public final class Utils {
    /**
     * Metodo que comprueba si la posicion esta dentro del rango de la lista.
     * 
     * @param x Lista.
     * @param i Posicion.
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    public final static void checkListPositionObject(List<?> x, int i) {
	if (x.size() <= i || x.get(i) == null) {
	    throw new IllegalStateException(
		    "List can't contain invalid object/position.");
	}
    }

    /**
     * Metodo que comprueba la validez de la cadena de texto.
     * 
     * @param string Cadena a validar.
     * @throws GameException
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    public final static void checkString(String string) {
	if (string == null || string.trim().length() == 0) {
	    throw new IllegalArgumentException("Invalid text");
	}
    }

    /**
     * Metodo que comprueba la validez del numero.
     * 
     * @param amount Numero a validar.
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    public final static void checkAmount(double amount) {
	if (amount < 0.0) {
	    throw new IllegalArgumentException("Invalid amount");
	}
    }

    /**
     * Metodo que comprueba la validez de la posicion.
     * 
     * @param pos Posicion a validar
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    public final static void checkNumber(int n) {
	if (n < 0) {
	    throw new IllegalArgumentException("Invalid number");
	}
    }

    /**
     * Metodo que comprueba que la lista introducida no tenga elementos null.
     * 
     * @param l Lista a validar
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    public final static void checkList(List<?> l) {
	if (l == null || l.isEmpty() || l.contains(null)) {
	    throw new IllegalStateException("Invalid list");
	}
    }

    /**
     * Metodo que comprueba la validez de un objeto que se le pasa como
     * parametro. Si es null lanza una exception
     * 
     * @param t Objeto a validar
     * @throws IllegalArgumentException cuando el parametro es invalido.
     */
    public final static <T> void checkObject(T t) {
	if (t == null) {
	    throw new IllegalArgumentException(
		    "Invalid object: it can't be null.");
	}
    }
}
