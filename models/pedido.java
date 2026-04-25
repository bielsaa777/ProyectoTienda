package models;

public class Pedido {

    private int id = 0;
    private Cliente idCliente;
    private Producto idProducto;
    private int cantidad;
    private String fecha;

    public Pedido(int id, Cliente idCliente, Producto idProducto, int cantidad, String fecha) {
        this.id = id;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }


    public Pedido() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Producto getIdProducto() {
        return this.idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


}
