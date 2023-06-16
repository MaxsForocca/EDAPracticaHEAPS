package EDAPracticaHEAPS.Heaps_Queue;

class Node<T> {
    private T data;
    private Node<T> izquierda;
    private Node<T> derecha;

    public Node(T data) {
        this.data = data;
        this.izquierda = null;
        this.derecha = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Node<T> N) {
        this.izquierda = N;
    }

    public Node<T> getDerecha() {
        return derecha;
    }

    public void setDerecha(Node<T> N) {
        this.derecha = N;
    }

    public boolean hasIzquierda() {
        return izquierda != null;
    }

    public boolean hasDerecha() {
        return derecha != null;
    }

    public boolean isLeaf() {
        return !hasIzquierda() && !hasDerecha();
    }
}
