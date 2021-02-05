package lopez_lopez_angela_monopoly_sprint5.exceptions;

/**
 * <p>
 * Titulo: Clase UserInterfaceException
 * </p>
 * <p>
 * Descripcion: Clase que maneja los errores de seleccion del menu.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class UserInterfaceException extends Exception {
    /**
     * Default serial id
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor con parametro
     * @param string Mensaje de error
     */
    public UserInterfaceException(String string) {
	super(string);
    }
}
