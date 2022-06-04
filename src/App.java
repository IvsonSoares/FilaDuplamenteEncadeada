public class App {
    public static void main(String[] args) throws Exception {
        Fila<Integer> fila = new Fila<Integer>();
        
        
        fila.add(10);
        fila.add(20);
        fila.add(30);
        fila.add(40);
        fila.add(50);
        fila.add(60);
        fila.add(70);
        //fila.remove();
        fila.set(7, 5);
        fila.add(10);
        //fila.set(0, 15);
        fila.printFila();

    }
}