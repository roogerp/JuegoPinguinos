package MODELO;

public abstract class CasillaNormal extends Casilla {

    public CasillaNormal(int posicion) {
        super(posicion);
    }

    @Override
    public void activar(Pinguino jugador, Partida partida) {
        // No hace nada
    }
}