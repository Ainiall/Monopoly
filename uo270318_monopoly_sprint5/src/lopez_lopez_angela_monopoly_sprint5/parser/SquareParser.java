package lopez_lopez_angela_monopoly_sprint5.parser;

import lopez_lopez_angela_monopoly_sprint5.exceptions.GameException;
import lopez_lopez_angela_monopoly_sprint5.exceptions.ParserException;
import lopez_lopez_angela_monopoly_sprint5.model.square.GoSquare;
import lopez_lopez_angela_monopoly_sprint5.model.square.LotSquare;
import lopez_lopez_angela_monopoly_sprint5.model.square.NonFeeSquare;
import lopez_lopez_angela_monopoly_sprint5.model.square.RailroadSquare;
import lopez_lopez_angela_monopoly_sprint5.model.square.Square;
import lopez_lopez_angela_monopoly_sprint5.model.square.TaxSquare;
import lopez_lopez_angela_monopoly_sprint5.model.square.UtilitySquare;
import lopez_lopez_angela_monopoly_sprint5.util.console.Console;
import uo270318.mp.tareaS12.collections_iterators.generics.model.LinkedList;
import uo270318.mp.tareaS12.collections_iterators.generics.model.List;

/**
 * <p>
 * Titulo: Clase SquareParser
 * </p>
 * <p>
 * Descripcion: Clase que maneja el parseo de las lineas.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class SquareParser {
    /**
     * Metodo que parsea una lista de lineas a una lista de casillas.
     * 
     * @param lines Lista de lineas
     * @return squares Lista de casillas
     * @throws GameException Si no cumple el formato de casillas necesario.
     */
    public List<Square> parse(List<String> lines) throws GameException {
	checkValidListSquares(lines);
	List<Square> squares = new LinkedList<Square>();
	int ln = 1;
	for (String line : lines) {
	    Square s;
	    try {
		if (!checkEmptyLine(line, ln)) {
		    s = parseLine(line, ln);
		    squares.add(s);
		}

	    } catch (ParserException ilfe) {
		Console.println("Formatting error at line " + ln + " "
			+ ilfe.getMessage());
	    }
	    ln++;
	}
	checkValidListSize(squares);
	return squares;
    }

    private void checkValidListSize(List<Square> squares) throws GameException {
	if(squares.size() < 12|| squares.size() > 40) {
	    throw new GameException("It's size should be 12-40");
	}
	
    }

    /**
     * Metodo que valida que una casilla sea valida.
     * 
     * @param lines Lista de casillas
     * @throws GameException Si no cumple con el formato de casillas necesario.
     */
    private void checkValidListSquares(List<String> lines)
	    throws GameException {
	if (!lines.get(0).equals("GoSquare,Go")) {
	    throw new GameException(
		    "It should start with GoSquare.");
	}
    }

    /**
     * Metodo que parsea cada linea en un objeto casilla.
     * 
     * @param line Linea a parsear
     * @param ln   Numero de linea
     * @return Objeto casilla segun su tipo
     * @throws ParserException Si no se reconoce como casilla.
     */
    private Square parseLine(String line, int ln) throws ParserException {
	String[] str = line.split(",");
	String type = str[0];
	String name = str[1];
	switch (type) {
	case "GoSquare":
	    chechHasAllParts(2, str, line, ln);
	    return new GoSquare(name, ln);
	case "NonFeeSquare":
	    chechHasAllParts(2, str, line, ln);
	    return new NonFeeSquare(name, ln);
	case "LotSquare":
	    chechHasAllParts(4, str, line, ln);
	    return new LotSquare(name, ln, toDouble(str[2], ln, line),
		    toDouble(str[3], ln, line));
	case "RailroadSquare":
	    chechHasAllParts(4, str, line, ln);
	    return new RailroadSquare(name, ln, toDouble(str[2], ln, line),
		    toDouble(str[3], ln, line));
	case "UtilitySquare":
	    chechHasAllParts(4, str, line, ln);
	    return new UtilitySquare(name, ln, toDouble(str[2], ln, line),
		    toDouble(str[3], ln, line));
	case "TaxSquare":
	    chechHasAllParts(3, str, line, ln);
	    return new TaxSquare(name, ln, toDouble(str[2], ln, line));
	}
	throw new ParserException("Unknown type", ln, line);
    }

    /**
     * Metodo que valida el parseo de texto a numero.
     * 
     * @param string Texto a parsear
     * @param ln     Numero de linea
     * @param line   Linea completa
     * @return Numero parseado
     * @throws ParserException Si no se puede parsear a numero.
     */
    private double toDouble(String string, int ln, String line)
	    throws ParserException {
	try {
	    return Double.parseDouble(string);
	} catch (NumberFormatException ile) {
	    throw new ParserException(string + " is not a number.", ln, line);
	}
    }

    /**
     * Metodo que valida que la linea tenga todos los campos necesarios.
     * 
     * @param i    Numero de campos que debe tener
     * @param str  Numero de campos que tiene
     * @param line Linea completa
     * @param ln   Numero de linea
     * @throws ParserException Si no tiene el numero de campos necesarios.
     */
    private void chechHasAllParts(int i, String[] str, String line, int ln)
	    throws ParserException {
	if (i != str.length) {
	    throw new ParserException("Invalid field parts", ln, line);
	}
    }

    /**
     * Metodo que valida si una linea esta vacía.
     * 
     * @param line
     * @param ln
     */
    private boolean checkEmptyLine(String line, int ln) {
	if (line.isEmpty() || line.trim() == "") {
	    //Logger.log("Empty line " + ln);
	    return true;
	} else {
	    return false;
	}
    }
}
