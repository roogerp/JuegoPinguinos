package MODELO;

public class Pinguino extends Jugador {

    private Inventario inventario;

    public Pinguino(String nombre, String color) {
        super(nombre, color);
        this.inventario = new Inventario();
    }

    @Override
    public void mover(int nuevaPosicion) {
        this.posicion = nuevaPosicion;
        if (this.posicion < 0) this.posicion = 0;


    }

    public Inventario getInventario() {
        return inventario;
    }
}