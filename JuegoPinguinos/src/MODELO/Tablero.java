package MODELO;

import java.util.ArrayList;
import java.util.Random;

public class Tablero {

    private ArrayList<Casilla> casillas;

    public Tablero(int tamaño) {
        casillas = new ArrayList<>();
        generarTablero(tamaño);
    }

    private void generarTablero(int tamaño) {
        Random r = new Random();

        for (int i = 0; i < tamaño; i++) {
            int tipo = r.nextInt(5);

            switch (tipo) {
                case 0: casillas.add(new Oso(i)); break;
                case 1: casillas.add(new Agujero(i)); break;
                case 2: casillas.add(new Trineo(i)); break;
                case 3: casillas.add(new Interrogante(i)); break;
            }
        }
    }

    public Casilla getCasilla(int posicion) {
        return casillas.get(posicion);
    }



    public int getTamaño() {
        return casillas.size();
    }
}