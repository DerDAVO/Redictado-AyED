package tp2.ejercicio4;

import tp2.ejercicio1y2.BinaryTree;

public class RedBinariaLlena {
    private BinaryTree<Integer> arbol;
    public RedBinariaLlena(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
        
        private int retardoReenvio(BinaryTree<Integer> arbol){
            int retHI=0,retHD=0;
            if(arbol.hasLeftChild()){
                retHI = retardoReenvio(arbol.getLeftChild());
            }
            if(arbol.hasRightChild()){
                retHD = retardoReenvio(arbol.getRightChild());
            }
            return Math.max(retHI,retHD)+arbol.getData();
        }
        public int retardoReenvio(){       
            return retardoReenvio(this.arbol); 
        }
    public static void main(String[] args) {
        BinaryTree<Integer> root = new BinaryTree<>(1);
        BinaryTree<Integer> node2 = new BinaryTree<>(11);
        BinaryTree<Integer> node3 = new BinaryTree<>(4);
        BinaryTree<Integer> node4 = new BinaryTree<>(3);
        BinaryTree<Integer> node5 = new BinaryTree<>(1);
        BinaryTree<Integer> node6 = new BinaryTree<>(8);
        BinaryTree<Integer> node7 = new BinaryTree<>(11);

        node2.addLeftChild(node4);
        node2.addRightChild(node5);
        node3.addLeftChild(node6);
        node3.addRightChild(node7);
        root.addLeftChild(node2);
        root.addRightChild(node3);


        RedBinariaLlena red = new RedBinariaLlena(root);
        System.out.println("El retardo de reenvio es: " + red.retardoReenvio());
    }
}
