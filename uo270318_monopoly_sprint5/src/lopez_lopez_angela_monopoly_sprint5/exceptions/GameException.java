package lopez_lopez_angela_monopoly_sprint5.exceptions;
/**
 * <p>
 * Titulo: Clase GameException
 * </p>
 * <p>
 * Descripcion: Clase que maneja los errores de usuario.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class GameException extends Exception {

    /**
     * Constructor con parametro
     * @param string Mensaje
     */
    public GameException(String string) {
	super(string);
    }

    /**
     * Default serial id
     */
    private static final long serialVersionUID = 1L;

}
