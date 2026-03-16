package MODELO;

import java.util.Random;

public class DadoNormal extends Item {

    public DadoNormal() {
        super("Dado Normal", 1);
    }

    public int tirar() {
        return new Random().nextInt(6) + 1;
    }
}