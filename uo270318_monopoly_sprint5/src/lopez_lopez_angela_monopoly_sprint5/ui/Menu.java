package lopez_lopez_angela_monopoly_sprint5.ui;

import lopez_lopez_angela_monopoly_sprint5.util.console.Console;

/**
 * <p>
 * Titulo: Clase Menu
 * </p>
 * <p>
 * Descripcion: Clase que muestra un menu de opciones por pantalla Devuelve la opción elegida por el
 * usuario
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class Menu {
    private String[] options = { "new plaYer (y or Y)",
	    "Delete player (d or D)", "new Board (b or B)",
	    "let's Play (p or P)", };

    public char readOption() {
	return Console.readChar(" Option ");
    }

    public void show() {
	for (String line : options) {
	    if ("".equals(line)) {
		Console.println("");
		continue;
	    }
	    Console.printf("\t%s\n", line);

	}
    }

}
