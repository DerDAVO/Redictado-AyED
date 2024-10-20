package tp2.ejercicio3;

import java.util.List;

import tp2.ejercicio1y2.BinaryTree;

public class ContadorArbolMain {

    public static void main(String[] args) {
        BinaryTree<Integer> root = new BinaryTree<>(1);
        BinaryTree<Integer> node2 = new BinaryTree<>(2);
        BinaryTree<Integer> node3 = new BinaryTree<>(3);
        BinaryTree<Integer> node4 = new BinaryTree<>(4);
        BinaryTree<Integer> node5 = new BinaryTree<>(5);
        BinaryTree<Integer> node6 = new BinaryTree<>(6);
        BinaryTree<Integer> node7 = new BinaryTree<>(7);
        // Establecer las relaciones (enlazar nodos)
        root.addLeftChild(node2);
        root.addRightChild(node3);
        node2.addLeftChild(node4);
        node2.addRightChild(node5);
        node3.addRightChild(node6);
        node5.addLeftChild(node7);
        ContadorArbol cantArbol = new ContadorArbol(root);
        List<Integer> lista = cantArbol.numerosParesInOrden();
        for(Integer i : lista) {
            System.out.println(i);
        }
    }
}
