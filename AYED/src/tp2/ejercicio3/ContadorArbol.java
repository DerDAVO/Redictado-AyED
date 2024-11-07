package tp2.ejercicio3;

import java.util.List;
import tp2.ejercicio1.BinaryTree;
import java.util.ArrayList;

public class ContadorArbol {
    /*
        Defina una clase Java denominada ContadorArbol cuya función principal es proveer métodos de
        validación sobre árboles binarios de enteros. Para ello la clase tiene como variable de instancia un
        BinaryTree<Integer>. Implemente en dicha clase un método denominado numerosPares() que
        devuelve en una estructura adecuada (sin ningún criterio de orden) todos los elementos pares del
        árbol (divisibles por 2).
    a) Implemente el método realizando un recorrido InOrden.
    b) Implemente el método realizando un recorrido PostOrden.
    */
    private BinaryTree<Integer> arbol;
    public ContadorArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    private void numerosParesInOrden(List<Integer> lista, BinaryTree<Integer> arbol){
        if(arbol.hasLeftChild()){
            numerosParesInOrden(lista, arbol.getLeftChild());
        }
        if(arbol.getData() % 2 == 0){
            lista.add(arbol.getData());
        }
        if(arbol.hasRightChild()){
            numerosParesInOrden(lista,arbol.getRightChild());
        }
        
    }
    public List<Integer> numerosParesInOrden() {
        List<Integer> lista = new ArrayList<Integer>();
        numerosParesInOrden(lista, this.arbol);
        return lista;
    }

    private void numerosParesPostOrden(List<Integer> lista, BinaryTree<Integer> arbol){
        if(arbol.hasLeftChild()){
            numerosParesPostOrden(lista, arbol.getLeftChild());
        }
        if(arbol.hasRightChild()){
            numerosParesPostOrden(lista,arbol.getRightChild());
        }
        if(arbol.getData() % 2 == 0){
            lista.add(arbol.getData());
        }
    }
    public List<Integer> numerosParesPostOrden() {
        List<Integer> lista = new ArrayList<Integer>();
        numerosParesPostOrden(lista, this.arbol);
        return lista;
    }
}
