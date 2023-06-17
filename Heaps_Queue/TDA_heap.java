package Heaps_Queue;
import java.util.ArrayList;

public class TDA_heap<T extends Comparable<T>>{
    private Node<T> root;
    private ArrayList<Node<T>> lista; 

    public TDA_heap(){
        this.root = null;
        this.lista = new ArrayList<Node<T>>();
    }
    public boolean isEmpty(){
        return this.root == null;
    }
    // Metodo insertar
    public void insertar(T dato){
        // indice del nuevo que sera agregado
        int indice = lista.size();
        Node<T> nuevo = new Node<T>(dato);
        lista.add(new Node<T>(dato));
        if(isEmpty()){
            this.root = nuevo;
        }else{
            // trabaja con el indice del padre
            int indicePadre = indice/2;
            // agregamos el nuevo nodo, siempre de izquierda a derecha 
            if(lista.get(indicePadre).getIzquierda() == null)
                lista.get(indicePadre).setIzquierda(nuevo);
            else
                lista.get(indicePadre).setDerecha(nuevo);
            int comp = dato.compareTo(lista.get(indice/2).getData());
            // mientras el indice del padre no sea menor a 0 (root no tiene padre)
            // el nuevo dato sea mayor
            while(indicePadre >= 0 && comp > 0){
                insertar(lista.get(indice), indice);
                indice = indicePadre;
                indicePadre = indice/2;
            }
        }
    }
    private void insertar(Node<T> nod, int indice){
        Node<T> padre = lista.get(indice/2);
        T aux = padre.getData();
        padre.setData(nod.getData());
        nod.setData(aux);
    }
    public void eliminar(int indice){
        // elementos del ultimo 
        Node<T> eliminado = lista.get(indice);
        if(eliminado.getIzquierda()==null){
            Node<T> padreElimin = lista.get(indice/2);
            if(padreElimin.getIzquierda() == eliminado){
                padreElimin.setIzquierda(padreElimin.getDerecha());
                padreElimin.setDerecha(null);
            }else{
                padreElimin.setDerecha(null);
            }
            lista.remove(indice);
        }else{
            int indiceUltimo = this.lista.size()-1;
            int indicePadreUltimo = indiceUltimo/2;
            // Cambiamos los valores del que sera eliminado
            lista.get(indice).setData(lista.get(indiceUltimo).getData());
            // elimina el ultimo (elemento a eliminar)
            this.lista.get(indicePadreUltimo);
            this.lista.remove(indiceUltimo);
        }
    }
    public T maxElemento(){
        return this.root.getData();
    }
    @Override 
    public String toString(){
        String toStr = "";
        for(Node<T> n : lista)
            toStr = toStr + n.toString();
        return toStr;
    }
}
