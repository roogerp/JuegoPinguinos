package MODELO;

import java.util.ArrayList;

public class Partida {

	public Partida() {
	}
	
    private Tablero tablero;
    private ArrayList<Pinguino> jugadores;
    private int turnoActual;

    public Partida(int tamañoTablero) {
        this.tablero = new Tablero(tamañoTablero);
        this.jugadores = new ArrayList<>();
        this.turnoActual = 0;
    }

    public void añadirJugador(Pinguino jugador) {
        jugadores.add(jugador);
    }

    public Pinguino getJugadorActual() {
        return jugadores.get(turnoActual);
    }

    public void siguienteTurno() {
        turnoActual = (turnoActual + 1) % jugadores.size();
    }

    public Tablero getTablero() {
        return tablero;
    }
    
    
    public ArrayList<Pinguino> getJugadores() {
        return jugadores;
    }
    
    
}