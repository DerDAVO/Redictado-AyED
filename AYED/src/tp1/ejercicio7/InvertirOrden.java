package tp1.ejercicio7;
import  java.util.ArrayList;
public class InvertirOrden {
    /*Implemente un método recursivo que invierta el orden de los elementos en un
    ArrayList.*/
    public static void helper(ArrayList<Integer> lista,ArrayList<Integer> aux ,int size) {
		if(size <= lista.size()-1) {
			helper(lista, aux, size+1);
			aux.add(lista.get(size));			
		}
	}
	public static void invertirOrden(ArrayList<Integer> lista){
		ArrayList<Integer> aux = new ArrayList<Integer>();
		helper(lista, aux, 0);
		lista.clear();
		lista.addAll(aux);
	}
    public static void main(String[] args) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		System.out.println("Lista inicializada");
		for(Integer i : lista) {
			System.out.println(i);
		}
		invertirOrden(lista);
		System.out.println("Lista invertida");
		for(Integer i : lista) {
			System.out.println(i);
		}
	}
}
