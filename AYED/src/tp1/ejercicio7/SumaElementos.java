package tp1.ejercicio7;
import java.util.LinkedList;

public class SumaElementos {
    // Implemente un método recursivo que calcule la suma de los elementos en un
    //LinkedList.
    public static int helper(int i,LinkedList<Integer> lista) {
		if(i <= lista.size()-1) {
			return lista.get(i)+helper(i+1, lista);
		}
		return 0;
	}
	public static int sumaRecursivaLinkedList(LinkedList<Integer> lista) {
		return helper(0, lista);
	}
	public static void main(String[] args) {
		LinkedList<Integer> lista = new LinkedList<Integer>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		System.out.println("Resultado :" + sumaRecursivaLinkedList(lista));
	}
   
}
