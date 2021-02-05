package lopez_lopez_angela_monopoly_sprint5.util.console;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * <p>
 * Titulo: Clase Console
 * </p>
 * <p>
 * Descripcion: Clase que simula la consola.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class Console {
	
	private static PrintStream out = System.out;
	private static InputStream in = System.in;
	
	private static Scanner keyboard = new Scanner( in );

	public static void setOut(PrintStream out) {
		Console.out = out;
	}

	public static void setIn(InputStream in) {
		Console.in = in;
		keyboard = new Scanner( Console.in );
	}

	public static String readString(String msg) {
		out.println( msg + ": ");
		keyboard.useDelimiter(System.lineSeparator());
		String res = keyboard.next();
		keyboard.reset();
		return res;
	}

	public static int readInteger(String msg) {
		out.println( msg + ": ");
		return keyboard.nextInt();
	}

	
	public static char readChar(String msg) {
		out.println( msg + ": ");
		keyboard.useDelimiter(System.lineSeparator());
		char res = keyboard.next().charAt(0);
		keyboard.reset();
		return res;
	}
	
	
	
	public static void println(String msg) {
		out.println( msg );
	}

	public static void printf(String fmt, Object... params) {
		out.printf( fmt, params );
	}

}