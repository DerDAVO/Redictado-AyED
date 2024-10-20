package tp2.ejercicio5;

import tp2.ejercicio1y2.BinaryTree;

public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> arbol;
    public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public int profundidad(int p,int nivel, BinaryTree<Integer> aux){
        if(p==nivel){
            return aux.getData();
        }else{// si no es el nivel buscado sigo con la recursion
            int total=0;
            if(aux.hasLeftChild()){
                total += profundidad(p,nivel+1,aux.getLeftChild());
            }
            if(aux.hasRightChild()){
                total+= profundidad(p,nivel+1,aux.getRightChild());
            }
            return total;
        }
    }
    public int sumaElementosProfundidad (int p){
        return profundidad(p,0,this.arbol);
    }
}
