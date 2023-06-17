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
    public void insertar(T dato){
        int indice = lista.size();
        Node<T> nuevo = new Node<T>(dato);
        lista.add(new Node<T>(dato));
        if(isEmpty()){
            this.root = nuevo;
        }else{
            // trabaja con el indice del padre
            int indicePadre = indice/2;
            // agregamos el nuevo nodo
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
        // casos de eliminacion
    }
    
    @Override 
    public String toString(){
        String toStr = "";
        for(Node<T> n : lista)
            toStr = toStr + n.toString();
        return toStr;
    }
}
