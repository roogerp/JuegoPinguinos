package MODELO;

public class Agujero extends Casilla {

    public Agujero(int posicion) {
        super(posicion);
    }

    @Override
    public void activar(Pinguino jugador, Partida partida) {
        jugador.mover(-3);
    }
}