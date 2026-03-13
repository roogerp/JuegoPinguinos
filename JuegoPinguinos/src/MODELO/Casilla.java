package MODELO;

public abstract class Casilla {

    protected int posicion;

    public Casilla(int posicion) {
        this.posicion = posicion;
    }

    public abstract void activar(Pinguino jugador, Partida partida);
}