package lopez_lopez_angela_monopoly_sprint5.util;

/**
 * Una implementación básica de Logger que simplemente envía los mensajes de
 * error a la salida estándar de errores
 */
public class Logger {

    public static void log(String msg) {
	System.err.println(msg);
    }
}
