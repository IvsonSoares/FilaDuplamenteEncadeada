public class Node<T> {

    public T dado;
    Node<T> proximo = null;
    Node<T> anterior = null;

    public Node(T dado){
        this.dado = dado;
    }

    
}