package MODELO;

import java.util.Random;

public class DadoNormal extends Item {

    public DadoNormal() {
        super("Dado Normal");
    }

    public int tirar() {
        return new Random().nextInt(6) + 1;
    }
}