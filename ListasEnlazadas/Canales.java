public class Canales {
    private Nodo cabeza;
    private Nodo cola;
    private class Nodo{
        public Youtuber dato;
        public Nodo anterior;
        public Nodo proximo;
        public Nodo(Youtuber dato, Nodo prox, Nodo anter){
            this.dato = dato;
            proximo = prox;
            anterior = anter;
        }
        public Nodo(Youtuber dato){
            this.dato = dato;
            proximo = null;
            anterior = null;
        }
    }
    public Canales(){
        cabeza = null;
    }

    public boolean estaVacia(){
        return cabeza == null;
    }

    public void agregar(Youtuber dato){
        Nodo nuevo = new Nodo(dato);
        if (estaVacia()){
            cabeza = cola = nuevo;
        } else {
            Nodo nodoActual = cabeza;
            while (nodoActual != null && nodoActual.dato.suscriptores >= nuevo.dato.suscriptores) { 
                nodoActual = nodoActual.proximo;
            }
            if (nodoActual == cabeza) {
                nodoActual.anterior = nuevo;
                nuevo.proximo = nodoActual;
                cabeza = nuevo;
            } else if (nodoActual == null) { // No encontró ninguno sobre el que sea mayor -> Póngase al final
                cola.proximo = nuevo;
                nuevo.anterior = cola;
                cola = nuevo;
            } else {
                nodoActual.anterior.proximo = nuevo;
                nuevo.anterior = nodoActual.anterior;
                nuevo.proximo = nodoActual;
                nodoActual.anterior = nuevo;
            }
        }
    }

    public void imprimir(){
        Nodo temp = cabeza;
        boolean fin = false;
        if (!estaVacia()){
            while(!fin){
                System.out.println(temp.dato);
                if(temp.proximo == null) {
                    fin = true;
                } else {
                    temp = temp.proximo;   
                }
            }
        } else {
            System.out.println("La lista está vacía.");
        }
    }
    
    public void eliminar(Youtuber dato){
        if(!estaVacia()){
            Nodo temp = cabeza;
            boolean encontrado = false;
            while (!encontrado && temp != null){
                if (temp.dato.nombre.equals(dato.nombre)) { // Mas seguro que comparar la dirección de memoria.
                    if (cabeza == cola){
                        cabeza = cola = null;
                    } else if (temp == cabeza){
                        cabeza = cabeza.proximo;
                        cabeza.anterior = null;
                    } else if (temp == cola) {
                        cola = cola.anterior;
                        cola.proximo = null;
                    } else {
                        temp.anterior.proximo = temp.proximo;
                        temp.proximo.anterior = temp.anterior;
                    }
                    encontrado = true;
                } else {
                    temp = temp.proximo;
                }
            }
            if (temp == null){
                System.out.println("No se encontró el canal.");
            }
        } else {
            System.out.println("La lista está vacía.");
        }
    }

    public int tamaño(){
        if (!estaVacia()){
            int tamaño = 0;
            Nodo temp = cabeza;            
            while (temp != null){
                tamaño += 1;
                temp = temp.proximo;
            }
            return tamaño;
        } else {
            return 0;
        }
    }

    public void misCanales(){
        int contador = 1;
        Nodo temp = cabeza;
        boolean fin = false;
        if (!estaVacia()){
            while(!fin){
                System.out.printf("\n%d) %s",contador,temp.dato.nombre);
                if(temp.proximo == null) {
                    fin = true;
                } else {
                    temp = temp.proximo;
                    contador += 1;
                }
            }
        } else {
            System.out.println("No hay canales está vacía.");
        }
    }

    public Youtuber mostrarCanal(int posicion){
        Nodo temp = cabeza;
        int rastrear = 1;
        while (rastrear < posicion){
            temp = temp.proximo;
            rastrear += 1;
        }
        temp.dato.mostrarCanal();
        return temp.dato;
    }

}

