package lopez_lopez_angela_monopoly_sprint5.exceptions;

/**
 * <p>
 * Titulo: Clase ParserException
 * </p>
 * <p>
 * Descripcion: Clase que maneja los errores de parseo de fichero.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class ParserException extends Exception {
    /**
     * Default serial id
     */
    private static final long serialVersionUID = 1L;
    /**
     * Atributos
     */
    private int lineNumber;
    private String line;

    /**
     * Constructor con parametros
     * 
     * @param string Mensaje informativo de error
     * @param ln     Numero de linea
     * @param line   Contenido de la linea
     */
    public ParserException(String string, int ln, String line) {
	super(string);
	this.lineNumber = ln;
	this.line = line;
    }

    /**
     * Metodo que muestra un mensaje de error personalizado
     */
    @Override
    public String getMessage() {
	return super.getMessage() + " en linea " + lineNumber
		+ " con contenido " + line;

    }

}
