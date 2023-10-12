package Models;

public class ListaEnlazada {
    private Nodo cabeza;
    private int cantidadNodos;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public int getCantidadNodos() {
        return cantidadNodos;
    }

    public void agregar(String nombres) {
        Nodo nuevoNodo = new Nodo(nombres);
        if(cabeza == null) {
            cabeza = nuevoNodo;
        }else {
            Nodo ultimoNodo = cabeza;
            while(ultimoNodo.getSiguiente() != null) {
                ultimoNodo = ultimoNodo.getSiguiente();
            }
            ultimoNodo.setSiguiente(nuevoNodo);
        }
        cantidadNodos++;
    }

    public void agregar(String nombres, int indice) {
        Nodo nuevoNodo = new Nodo(nombres);
        if(indice == 0) {
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
        }else {
            Nodo actualNodo = cabeza;
            int contador = 0;

            while (contador < indice - 1 && actualNodo != null) {
                actualNodo = actualNodo.getSiguiente();
                contador++;
            }

            if(actualNodo != null) {
                nuevoNodo.setSiguiente(actualNodo.getSiguiente());
                actualNodo.setSiguiente(nuevoNodo);
            }else {
                System.out.println("Indice fuera de rango.");
            }
        }
        cantidadNodos++;
    }

    public void agregarAlInicio(String nombres) {
        Nodo nuevoNodo = new Nodo(nombres,cabeza);
        cabeza = nuevoNodo;
        cantidadNodos++;
    }

    public void ordenar() {
        cabeza = ordenamientoRapido(cabeza);
    }
    /**
     * Ordenamiento por quick sort
     * @param nodo El nodo cabeza
     * @return El nodo ordenado
     */
    private Nodo ordenamientoRapido(Nodo nodo) {
        if(nodo == null || nodo.getSiguiente() == null) {
            return nodo;
        }

        Nodo pivotNodo = nodo;
        Nodo menorNodo = null;
        Nodo mayorNodo = null;

        Nodo actualNodo = nodo.getSiguiente();

        while (actualNodo != null) {
            Nodo siguienteNodo = actualNodo.getSiguiente();
            if(actualNodo.getNombres().compareTo(pivotNodo.getNombres()) < 0) {
                actualNodo.setSiguiente(menorNodo);
                menorNodo = actualNodo;
            }else {
                actualNodo.setSiguiente(mayorNodo);
                mayorNodo = actualNodo;
            }
            actualNodo = siguienteNodo;
        }

        menorNodo = ordenamientoRapido(menorNodo);
        mayorNodo = ordenamientoRapido(mayorNodo);

        pivotNodo.setSiguiente(mayorNodo);
        
        if(menorNodo == null) {
            return pivotNodo;
        }

        Nodo ultimoMenor = menorNodo;
        while (ultimoMenor.getSiguiente() != null) {
            ultimoMenor = ultimoMenor.getSiguiente();
        }
        ultimoMenor.setSiguiente(pivotNodo);

        return menorNodo;
    }

    public void eliminarPrimero() {
        if (cabeza != null) {
            cabeza = cabeza.getSiguiente();
            cantidadNodos--;
        }
    }

    public void eliminarUltimo(){
        if (cabeza != null) {
            if (cabeza.getSiguiente() == null) {
                cabeza = null;
            } else {
                Nodo actual = cabeza;
                while (actual.getSiguiente().getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(null);
            }
            cantidadNodos--;
        }
    }

    public void eliminarPorIndice(int indice) {
        if (cabeza != null && indice >= 0) {
            if (indice == 0) {
                cabeza = cabeza.getSiguiente();
            } else {
                Nodo actual = cabeza;
                int contador = 0;

                while (contador < indice - 1 && actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                    contador++;
                }

                if (actual.getSiguiente() != null) {
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                }
            }
            cantidadNodos--;
        }
    }

    public void mostrar() {
        Nodo actualNodo = cabeza;
        while (actualNodo != null) {
            System.out.println(actualNodo.getNombres());
            actualNodo = actualNodo.getSiguiente();
        }
    }
}
