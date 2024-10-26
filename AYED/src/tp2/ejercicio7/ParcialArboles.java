package tp2.ejercicio7;
import tp2.ejercicio1y2.BinaryTree;
public class ParcialArboles {

    private BinaryTree<Integer> ab;
    public BinaryTree<Integer> buscarNodo(int num,BinaryTree<Integer> ab){
        //Buscar un  nodo cuyo valor sea num
        if(ab.getData() == num){
            return ab;
        }
        BinaryTree<Integer> aux = null;
        if(ab.hasLeftChild()){
            aux = buscarNodo(num,ab.getLeftChild());
        }
        if(ab.hasRightChild() && aux==null){
            aux = buscarNodo(num,ab.getRightChild());
        }
        return aux;
    }

    // Este metodo tiene el fin de verificar si el hijo izquierdo del nodo con valr num
    // tiene mas hijos con un solo nodo que el del hijo derecho
    public int unicoHijo(BinaryTree<Integer> ab){
        int aux = 0;
        if(ab.hasLeftChild()){
            aux += unicoHijo(ab.getLeftChild());
        } 
        if(ab.hasRightChild()){
            aux += unicoHijo(ab.getRightChild());
        }
        if((ab.hasLeftChild() && !ab.hasRightChild())||(ab.hasRightChild()&&!ab.hasLeftChild())){
            aux++;
        }
        return aux;
    }
    public boolean isLeftTree(int num){
        //Buscar un  nodo cuyo valor sea num
        BinaryTree<Integer> bt = buscarNodo(num,this.ab);
        int hi = -1,hd = -1;
        hi = unicoHijo(bt.getLeftChild());
        hd = unicoHijo(bt.getRightChild());
        return hi>hd;
    }

}