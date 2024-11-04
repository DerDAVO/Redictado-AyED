package tp3.ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}

	// Ejercicio 2 
	// Inciso a : Numeros mayores que preorden

	/**
	 *Meotodo que retorna una lista con los elementos impares de un arbol "a" que sean mayores al valor 
	 "n" pasados como parametros , recorrido en preorden.
	 * @return
	 */
	private void numerosMayoresQuePreOrden(GeneralTree<Integer> a, Integer n, List<Integer> lista){
			
		if((a.getData() > n)&&(n%2 != 0)){
			lista.add(a.getData());
		}
		List<GeneralTree<Integer>> children = a.getChildren();
		
		for(GeneralTree<Integer> child : children){	
			numerosMayoresQuePreOrden(child, n, lista);
		} // Recorro por cada hijo del del nodo actual
	}
	 public List<Integer> numerosMayoresQuePreOrden(GeneralTree<Integer> a, Integer n){
		List<Integer> res = new LinkedList<Integer>();
		numerosMayoresQuePreOrden(a, n, res);
		return res;
	}
	public int altura() {	 
			
		return 0;
	}
	
	public int nivel(T dato){
		return 0;
	  }

	public int ancho(){
		
		return 0;
	}
}