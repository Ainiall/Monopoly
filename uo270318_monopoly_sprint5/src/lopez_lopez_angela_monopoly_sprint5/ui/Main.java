package lopez_lopez_angela_monopoly_sprint5.ui;

import lopez_lopez_angela_monopoly_sprint5.presenter.ColoredConsolePresenter;
import lopez_lopez_angela_monopoly_sprint5.presenter.GamePresenter;

/**
 * <p>
 * Titulo: Clase Main
 * </p>
 * <p>
 * Descripcion: Clase que muestra una partida de Monopoly.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class Main {
    // para imprimir con color los mensajes del handler
    private static GamePresenter gp = new ColoredConsolePresenter();

    public static void main(String[] args) {
	new Main().run();
    }

    /**
     * Metodo que ejecuta el juego
     */
    private void run() {
	try {
	    new UserInterface().run();
	} catch (RuntimeException e) {
	    handlerDefaultRuntimeException(e);
	}
    }

    /**
     * Metodo auxiliar que devuelve el presenter.
     * 
     * @return gp GamePresenter
     */
    public static GamePresenter getGp() {
	return gp;
    }

    /**
     * Metodo que maneja las excepciones en ultima instancia.
     * 
     * @param e Excepcion
     */

    private void handlerDefaultRuntimeException(RuntimeException rte) {
	gp.defaultHanlder(rte.getMessage());
    }
}
