package tp2.ejercicio1y2;
import tp1.ejercicio8.Queue;
public class BinaryTree<T> {
    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;

    public BinaryTree(T data) {
        this.data = data; 
    }
    public BinaryTree() {
		super();
	}
    public int contarHojas(){
        if(this.isEmpty()){
            return 0;
        }
        if(this.isLeaf()){
            return 1;
        }
        return this.getLeftChild().contarHojas() + this.getRightChild().contarHojas();
    }
    public BinaryTree<T> espejo(){
        BinaryTree<T> arbEspejo = new BinaryTree<T>(this.getData());
        if(this.hasLeftChild()) {
            arbEspejo.addRightChild(this.getLeftChild().espejo());
        }
        if(this.hasRightChild()) {
            arbEspejo.addLeftChild(this.getRightChild().espejo());
        }
        return arbEspejo;

    }
    public void entreNiveles(int n, int m){
            int nivel = 0;
            BinaryTree<T> ab = null;
            Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
            cola.enqueue(this);
            cola.enqueue(null);
            while (!cola.isEmpty() && nivel <= m) {
                ab = cola.dequeue();
                if (ab != null) {
                    if(nivel >= n && nivel <= m) {
                        System.out.print(ab.getData());
                    }
                    if(!((nivel+1) > m)){
                        if (ab.hasLeftChild()) {
                            cola.enqueue(ab.getLeftChild());
                        }
                        if (ab.hasRightChild()) {
                            cola.enqueue(ab.getRightChild());
                        }
                    }
                    
                } else if (!cola.isEmpty()) {
                            cola.enqueue(null);
                            nivel++;
            }
        }
    }



    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }
    public void addLeftChild(BinaryTree<T> leftChild) {
        this.leftChild = leftChild;
    }
    public BinaryTree<T> getRightChild() {
        return rightChild;
    }
    public void addRightChild(BinaryTree<T> rightChild) {
        this.rightChild = rightChild;
    }
    public void removeLeftChild() {
        leftChild = null;
    }
    public void removeRightChild() {
        rightChild = null;
    }
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }
    public boolean isEmpty() {
        return this.isLeaf() && this.getData() == null;
    }
    public boolean hasLeftChild() {
        return leftChild != null;
    }
    public boolean hasRightChild() {
        return rightChild != null;
    }
    public void recorrerInOrden(){
        if(hasLeftChild()){
            this.getLeftChild().recorrerInOrden();
        }
        System.out.println(this.getData());
        if(hasRightChild()){
            this.getRightChild().recorrerInOrden();
        }
    }
    public String toString() {
        return data.toString();
    }
    
}

