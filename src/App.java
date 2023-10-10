import Models.ListaEnlazada;

public class App {
    public static void main(String[] args) throws Exception {
        ListaEnlazada lista = new ListaEnlazada();
        lista.agregar("Luis");
        lista.agregar("Carlos");
        lista.agregar("Diego");
        lista.agregar("Alex");

        System.out.println("Lista original:");
        lista.mostrar();

        lista.ordenar();

        lista.eliminarPrimero();
        System.out.println("Lista Ordenada:");
        lista.mostrar();
        System.out.println("La cantidad de elementos es "+lista.getCantidadNodos());
    }
}
