package MODELO;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Item> items;
    private int peces;
    private int bolas;
    private int dados;

    public Inventario() {
        items = new ArrayList<>();
        peces = 0;
        bolas = 0;
        dados = 0;
    }

    public void añadirPez() {
        if (peces < 2) peces++;
    }

    public boolean usarPez() {
        if (peces > 0) {
            peces--;
            return true;
        }
        return false;
    }

    public void añadirBolas(int cantidad) {
        if (bolas + cantidad <= 6)
            bolas += cantidad;
    }

    public void añadirDadoRapido() {
        if (dados < 3)
            items.add(new DadoRapido());
    }

    public void añadirDadoLento() {
        if (dados < 3)
            items.add(new DadoLento());
    }
}