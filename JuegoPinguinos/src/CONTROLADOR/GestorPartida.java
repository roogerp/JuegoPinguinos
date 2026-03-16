package CONTROLADOR;


import java.util.Random;

import MODELO.*;

public class GestorPartida {

    private Partida partida;
    private GestorTablero gestorTablero;
    private GestorJugador gestorJugador;
    private GestorBBDD gestorBBDD;
    private Random random;

    public GestorPartida() {
        this.partida = null;
        this.gestorTablero = new GestorTablero();
        this.gestorJugador = new GestorJugador();
        this.gestorBBDD = new GestorBBDD();
        this.random = new Random();
    }

    public void nuevaPartida() {
    	this.partida = new Partida();
    }

    public int tirarDado(Jugador j, Dado dadoOpcional) {

        int resultado = dadoOpcional.tirar(random);

        gestorJugador.jugadorSeMueve(j, resultado, this.partida.getTablero());

        return resultado;
    }

    public void ejecutarTurnoCompleto() {
        // ejecutar  lógica completa del turno
    }




    public void procesarTurnoJugador(Jugador j) {
        // procesar turno de jugador
    }

    public void actualizarEstadoTablero() {
        // actualizar estado del tablero
    }

    public void siguienteTurno() {
        // pasar al siguiente turno
    }




    public Partida getPartida() {
        return this.partida;
    }




    public void guardarPartida() {
        // para guardar la partida por Gestor BBDD
    }



    public void cargarPartida(int id) {
        // para cargar partida desde BBDD
    }
}