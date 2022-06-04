public class Fila<T> {
    Node<T> base = null;
    Node<T> topo = null;
    private int size = 0;


    public Fila() {}


    public void add(T element){
        Node<T> elt = new Node<T>(element);
        this.size++;        
        if(this.base == null){
            this.topo = elt;
            this.base = this.topo;
        }else {

            this.topo.proximo = elt;
            this.topo.proximo.anterior = topo;
            this.topo = this.topo.proximo;

        }

    }

    public int getSize(){
        return this.size;
    }
    
    // T remove(int pos);
    public T remove(int pos){
        return remove(getNode(pos));
    }

    // T remove(Node<T> node);
    private T remove(Node<T> node){
        T dado = node.dado;
        if(node.equals(this.base)){
            this.base = this.base.proximo;
        }
        else if(node.equals(this.topo)){
            this.topo = topo.anterior;
            this.topo.proximo = null;
        } else{
            node.proximo.anterior = node.anterior;
            node.anterior.proximo = node.proximo;
        }
        this.size--;
        return dado;
    }

    //void set(int pos, T value)
    public void set(int pos, T value){
        Node<T> atual = new Node<T>(value);
        if(pos == 0){
            atual.proximo = this.base;
            this.base = atual;
        }
        else if(pos == size){
            add(value);
        } else {
            atual.proximo = getNode(pos);
            atual.anterior = getNode(pos).anterior;
            getNode(pos).anterior.proximo = atual;
        }

    }

    //T get(int pos);
    public T get(int pos){
        return getNode(pos).dado;
    }

    // Node<T> getNode(int pos);
    public Node<T> getNode(int pos){
        double halfList = (double)this.size / 2;
        if(pos < 0 || pos > this.size){
            throw new Error("Posicao Invalida");
        }

        if(pos > halfList){
            Node<T> element = this.topo;
            int countDown = this.size - 1;
            while(true){
                if(countDown == pos){
                    return element;
                }
                element = element.anterior;
                countDown--;
            }
        } else {
            Node<T> element = this.base;
            int countUp = 0;
            while(true){
                if(countUp == pos){
                    return element;
                }
                element = element.proximo;
                countUp++;
            }
        }
    }

    // public Node<T> remove(){
    //     this.size--;
    //     Node<T> element = this.base;
    //     this.base = this.base.proximo;
    //     return element;
    // }

    public void clear(){
        this.size = 0;
        this.base = null;
        this.topo = null;
    }

    public boolean isEmpty(){
        if(this.base == null && this.topo == null){
            return true;
        }
        return false;
    }

    public void printFila(){
        Node<T> element = this.base;
        if(getSize() == 0){
            System.out.println("Empty List");
        } else {
            while(element != null){
                System.out.println(element.dado);
                element = element.proximo;
            }
        }
    }
}