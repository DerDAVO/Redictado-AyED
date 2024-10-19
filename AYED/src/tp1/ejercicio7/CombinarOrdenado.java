package tp1.ejercicio7;

import java.util.ArrayList;

public class CombinarOrdenado {
	public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1,ArrayList<Integer> lista2){
		int i=0,j=0;
		ArrayList<Integer> nuevaLista = new ArrayList<Integer>();
		while(i < lista1.size() && j < lista2.size()) {
			if(lista1.get(i) < lista2.get(j)) {
				nuevaLista.add(lista1.get(i));
				i++;
			}else {
				nuevaLista.add(lista2.get(j));
				j++;
			}
			
		}
		while(i<lista1.size()) {
			nuevaLista.add(lista1.get(i));
			i++;
		}
		while(j<lista2.size()) {
			nuevaLista.add(lista2.get(j));
			j++;
		}
		
		return nuevaLista;
	}
	public static void main(String[] args) {
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		
		l1.add(1);
		l1.add(7);
		l2.add(3);
		l2.add(4);
		
		ArrayList<Integer> resultado = combinarOrdenado(l1, l2);
		System.out.println("Resultado del merge");
		for(Integer n : resultado) {
			System.out.println("Numero : "+n);
		}
	}
}
