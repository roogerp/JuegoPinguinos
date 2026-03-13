package CONTROLADOR;

import MODELO.*;

public class GestorJugador {

    public void jugadorUsaItem(String nombreItem) {
        // uso de item por  jugador 
    }

    public void jugadorSeMueve(Jugador j, int pasos, Tablero t) {
    	int nuevaPos = j.getPosicion()+pasos;
    	
    	if(nuevaPos > 49) {
    		nuevaPos = 49;
    	}
    	
    	if (nuevaPos < 0 ) {
    		nuevaPos = 0;
    	}
    	
    	j.setPosicion(nuevaPos);
    }

    public void jugadorFinalizaTurno(Jugador j) {
        // fin del turno jugador
    }

    public void piguinoEvento(Pinguino p) {
        // evento del pingüino
    }

    public void pingüinoGuerra(Pinguino p1, Pinguino p2) {
        // guerra entre pingüinos
    }

    public void focaInteractua(Pinguino p, Foca f) {
        // interacción con la foca
    }
}