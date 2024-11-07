package tp2.ejercicio6;

import tp2.ejercicio1.BinaryTree;

public class Transformacion {
    private BinaryTree<Integer> arbol;
    public Transformacion(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    private int suma(BinaryTree<Integer> aux){
        int dataAux=0;
        if(aux.isLeaf()){
            dataAux=aux.getData();
            aux.setData(0);
            return dataAux; // tengo que guardar el valor anterior de la hoja 
        }
        int total=0;
        if(aux.hasLeftChild()){
            total += suma(aux.getLeftChild());
        }
        if(aux.hasRightChild()){
            total+= suma(aux.getRightChild());
        }
        dataAux = aux.getData();
        aux.setData(total);
        return dataAux + total;
    
    }
    public BinaryTree<Integer> suma(){
        suma(this.arbol);
        return this.arbol;
    }
}
