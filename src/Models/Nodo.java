package Models;

public class Nodo {
    private String nombres;
    private Nodo siguiente;

    public Nodo(String nombres) {
        this.nombres = nombres;
        this.siguiente = null;
    }
    public Nodo(String nombres, Nodo siguiente) {
        this.nombres = nombres;
        this.siguiente = siguiente;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Nodo getSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}