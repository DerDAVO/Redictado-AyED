package tp2.ejercicio3;
import tp2.ejercicio1y2.BinaryTree;
public class PruebaMain {
    public static void main(String[] args) {
        
        BinaryTree<Integer> root = new BinaryTree<>(1);
        BinaryTree<Integer> node2 = new BinaryTree<>(2);
        BinaryTree<Integer> node3 = new BinaryTree<>(3);
        
        root.addLeftChild(node2);
        root.addRightChild(node3);
        
        root.recorrerInOrden();
    }
}
