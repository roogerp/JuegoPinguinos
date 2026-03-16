package MODELO;

import java.util.Random;

public class DadoRapido extends Item {

    public DadoRapido() {
        super("Dado Rapido", 1);
    }

    public int tirar() {
        return new Random().nextInt(6) + 5;
    }
}