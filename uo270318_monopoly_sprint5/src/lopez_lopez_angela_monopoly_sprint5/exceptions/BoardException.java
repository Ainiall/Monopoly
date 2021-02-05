package lopez_lopez_angela_monopoly_sprint5.exceptions;

import java.io.IOException;
/**
 * <p>
 * Titulo: Clase BoardException
 * </p>
 * <p>
 * Descripcion: Clase que maneja los errores de fichero.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class BoardException extends IOException{

    /**
     * Constructor con parametro
     * @param string Mensaje
     */
    public BoardException(String string) {
	super(string);
    }

    /**
     * Default serial id
     */
    private static final long serialVersionUID = 1L;
    
}
