package MODELO;

public abstract class Jugador {

    protected String nombre;
    protected String color;
    protected int posicion;
    protected Inventario inventario;

    public Jugador(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
        this.posicion = 0;
        this.inventario = new Inventario();
    }

    public abstract void mover(int pasos);

    public Inventario getInventario() {
        return inventario;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}