package model;

public class Producto {
    private int idProducto;
    private String nombre;
    private int cantidad;
    private boolean estado;

    public Producto(int idProducto, String nombre, boolean estado, int cantidad) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.estado = estado;
        this.cantidad=cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean isEstado() {
        return estado;
    }
}
