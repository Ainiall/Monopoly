package lopez_lopez_angela_monopoly_sprint5.util;

/**
 * Una implementaci�n b�sica de Logger que simplemente env�a los mensajes de
 * error a la salida est�ndar de errores
 */
public class Logger {

    public static void log(String msg) {
	System.err.println(msg);
    }
}
