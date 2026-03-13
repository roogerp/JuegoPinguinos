package MODELO;

public class Oso extends Casilla {

    public Oso(int posicion) {
        super(posicion);
    }

    @Override
    public void activar(Pinguino jugador, Partida partida) {
        if (jugador.getInventario().usarPez()) {
            // Soborna al oso
        } else {
            jugador.setPosicion(0);
        }
    }
}