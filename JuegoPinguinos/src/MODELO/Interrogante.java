package MODELO;

import java.util.Random;

public class Interrogante extends Casilla {

    public Interrogante(int posicion) {
        super(posicion);
    }

    @Override
    public void activar(Pinguino jugador, Partida partida) {
        Random r = new Random();
        int evento = r.nextInt(4);

        switch (evento) {
            case 0: jugador.getInventario().añadirPez(); break;
            case 1: jugador.getInventario().añadirBolas(r.nextInt(3) + 1); break;
            case 2: jugador.getInventario().añadirDadoRapido(); break;
            case 3: jugador.getInventario().añadirDadoLento(); break;
        }
    }
}