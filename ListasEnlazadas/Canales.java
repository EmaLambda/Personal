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

    public void agregarDato(Youtuber dato){
        Nodo nuevo = new Nodo(dato);
        if (estaVacia()){
            cabeza = cola = nuevo;
        } else {
            Nodo temp = cabeza;
            boolean encontrado = false;
            while (!encontrado){
                if (temp.proximo != null) {
                    if (nuevo.dato.suscriptores > temp.dato.suscriptores) {
                        if (temp != cabeza){
                            temp.anterior.proximo = nuevo;
                            nuevo.anterior = temp.anterior;
                            temp.anterior = nuevo;
                            nuevo.proximo = temp;
                        } else {
                            temp.anterior = nuevo;
                            nuevo.proximo = temp;
                            cabeza = nuevo;
                        }
                    }
                } else {
                    if (nuevo.dato.suscriptores > temp.dato.suscriptores){
                        temp.anterior.proximo = nuevo;
                        nuevo.anterior = temp.anterior;
                        temp.anterior = nuevo;
                        nuevo.proximo = temp = cola;
                    } else {
                        cola.proximo = nuevo;
                        nuevo.anterior = cola;
                        cola = nuevo;
                    }
                    encontrado = true;
                }
            }
        }
    }

    public void imprimir(){
        Nodo temp = cabeza;
        boolean fin = false;
        if (temp != null){
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
        Nodo temp = cabeza;
        if(temp == null){
            System.out.println("No hay nada en la lista");
        } else{
            boolean fin = true;
            // TODO: Borrar en caso de que sea cabeza
            while (fin){
                if (temp.dato == dato){
                    cabeza = temp.proximo;
                    fin = false;
                } else if (temp.proximo != null && temp.proximo.dato == dato){
                    temp.proximo = temp.proximo.proximo;
                    fin = false;
                } else if (temp.proximo != null){
                    temp = temp.proximo;
                } else {
                    System.out.println("No se encontró el dato.");
                    fin = false;
                }
            }
        }
    }
}

