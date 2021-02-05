package lopez_lopez_angela_monopoly_sprint5.util.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import lopez_lopez_angela_monopoly_sprint5.exceptions.BoardException;
import uo270318.mp.tareaS12.collections_iterators.generics.model.LinkedList;
import uo270318.mp.tareaS12.collections_iterators.generics.model.List;

/**
 * Una clase de utilidad para leer / escribir lineas de texto desde / hacia un
 * fichero de texto.
 */
public class FileUtil {

    public static List<String> readLines(String inFileName)
	    throws BoardException {
	List<String> result = new LinkedList<String>();
	BufferedReader in;
	try {
	    in = new BufferedReader(new FileReader(inFileName));
	} catch (FileNotFoundException e) {
	    throw new BoardException("File not found.");
	}
	try {
	    try {
		while (in.ready()) {
		    result.add(in.readLine());
		}
	    } finally {
		in.close();
	    }
	} catch (IOException ioe) {
	    throw new RuntimeException(ioe);
	}

	return result;
    }

    public void saveToFile(String outFileName, List<String> lines) {
	try {
	    BufferedWriter out = new BufferedWriter(
		    new FileWriter(outFileName));
	    try {
		for (String l : lines) {
		    out.write(l);
		    out.newLine();
		}
	    } finally {
		out.close();
	    }
	} catch (IOException ioe) {
	    throw new RuntimeException(ioe);
	}
    }

}