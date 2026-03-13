package MODELO;


import java.util.Random;

public class DadoLento extends Item {

    public DadoLento() {
        super("Dado Lento");
    }

    public int tirar() {
        return new Random().nextInt(3) + 1;
    }
}
