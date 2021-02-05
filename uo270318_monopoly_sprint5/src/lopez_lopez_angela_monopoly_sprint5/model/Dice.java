package lopez_lopez_angela_monopoly_sprint5.model;

import java.util.Random;
/**
 * <p>
 * Titulo: Clase Dice
 * </p>
 * <p>
 * Descripcion: Clase que simula un dado.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class Dice {

    /**
     * Metodo que lanza el dado y devuelve la puntuacion asignada a esa tirada
     * 
     * @return num Puntuacion obtenida
     */
    //publico para pruebas
    public int roll() {
	Random random = new Random();
	int num = 1 + random.nextInt(6);
	return num;
    }
}
