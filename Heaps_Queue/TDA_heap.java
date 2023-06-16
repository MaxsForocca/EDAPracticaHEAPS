package Heaps_Queue;
import java.util.ArrayList;

public class TDA_heap<T extends Comparable<T>>{
    private Node<T> root;
    private ArrayList<T> lista; 
    public TDA_heap(){
        this.root = null;
        this.lista = new ArrayList<T>();
    }
    public boolean isEmpty(){
        return this.root == null;
    }
    public void insertar(T dato){
        if(isEmpty()){
            this.root = new Node<T>(dato);
        }else{
            // casos de insercion
        }
        lista.add(dato);
    }
    public void eliminar(int indice){
        // casos de eliminacion
    }
    /*
    @Override 
    public String toString(){
        String toStr;
        for(T element : lista)
            toStr = toStr + 
    }
     */
}
