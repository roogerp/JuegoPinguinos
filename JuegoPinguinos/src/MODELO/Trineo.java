package MODELO;


public class Trineo extends Casilla {

    public Trineo(int posicion) {
        super(posicion);
    }

    @Override
    public void activar(Pinguino jugador, Partida partida) {
        jugador.mover(5);
    }
}