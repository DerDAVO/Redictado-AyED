package tp1.ejercicio7;
import java.util.ArrayList;
import java.util.Scanner;

import tp1.ejercicio3.Estudiante;
import java.util.List;
import java.util.LinkedList;
public class TestArrayList {
    /* a. Escriba una clase llamada TestArrayList cuyo método main recibe una secuencia de
        números, los agrega a una lista de tipo ArrayList, y luego de haber agregado todos los
        números a la lista, imprime el contenido de la misma iterando sobre cada elemento
    */

    //d. Escriba un método que realice las siguientes acciones:
    public static void metodoInicisoD(){
        //cree una lista que contenga 3 estudiantes
        Estudiante estudiante1 = new Estudiante("Juan","Perez","c2","juanperez@gmail.com","Calle 123");
        Estudiante estudiante2 = new Estudiante("Maria","Perez","c2","mariaperez@gmail.com","Calle 123");
        Estudiante estudiante3 = new Estudiante("Pedro","Perez","c2","pedroperez@gmail.com","Calle 123");
        LinkedList<Estudiante> lista = new LinkedList<Estudiante>();
        lista.add(estudiante1);
        lista.add(estudiante2);
        lista.add(estudiante3);
        //genere una nueva lista que sea una copia de la lista del inciso i
        LinkedList<Estudiante> lista2 = new LinkedList<Estudiante>(lista);
        //imprima el contenido de la lista original y el contenido de la nueva lista
        System.out.println("Contenido de la lista original");
        for(Estudiante estudiante : lista) {
            System.out.println(estudiante.tusDatos());
        }
        System.out.println("Contenido de la lista copia");
        for(Estudiante estudiante : lista2) {
            System.out.println(estudiante.tusDatos());
        }
        //modifique algún dato de los estudiantes
        estudiante2.setApellido("Lopez");
        // vuelva a imprimir el contenido de la lista original y el contenido de la nueva lista.
        // ¿Qué conclusiones obtiene a partir de lo realizado?
        System.out.println("Contenido de la lista original");
        for(Estudiante estudiante : lista) {
            System.out.println(estudiante.tusDatos());
        }
        System.out.println("Contenido de la lista copia");
        for(Estudiante estudiante : lista2) {
            System.out.println(estudiante.tusDatos());
        }
        // Al tener las referencias de los estudiantes cuando modifico algún dato de ellos
        // se ve reflejado en ambas listas (original y copia)
        // Si hiciera un cambio en la lista original, no se ve reflejado en la lista copia
        
        // ¿Cuántas formas de copiar una lista existen? ¿Qué diferencias existen entre ellas?
        // Hay varias formas de copiar una lista
        /*
        - Por constructor de listas
            List<> copia = new List<>(original);
        - Meotod addAll
            List<> copiar = new ArrayList<>();
            copiar.addAll(original);
        - Metodo clone
            List<> copiar = original.clone();
        La diferencia entre estas formas de copiar redica en como queremos que se copien los
        elementos de la lista original.
        Copias superficiales: copia de referencia
            - Por constructor de listas
            - Meotod addAll
        Copias profundas: copia de valor
            - Metodo clone

        */
        metodoInicisoEAgregarEstudiante(lista);

    }

    /*e. A la lista del punto 7d, agregue un nuevo estudiante. Antes de agregar, verifique que el
    estudiante no estaba incluido en la lista.*/
    public static void metodoInicisoEAgregarEstudiante(List<Estudiante> lista){
        Estudiante estudiante = new Estudiante("Juan","Perez","c2","juanperez@gmail.com","Calle 123");
        if(lista.contains(estudiante)){
            lista.add(estudiante);
        }
    }
    /*f. Escriba un método que devuelva verdadero o falso si la secuencia almacenada en la
    lista es o no capicúa:*/
    public boolean esCapicua(ArrayList<Integer> lista){
        List<Integer> lista2 = new ArrayList<Integer>(lista);
        boolean ok = true;
        int j=0,i=lista2.size()-1;

        while(i>=0 && j<lista2.size()&&ok){
            if(lista2.get(i)!=lista2.get(j)){
                ok=false;
            }
            i--;
            j++;
        }
        return ok;
    }
    




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Ingrese los "+n+ " numeros :");

        ArrayList<Integer> lista = new ArrayList<Integer>();
        
        for(int i=0;i<n;i++) {
            lista.add(scanner.nextInt());
        }
        for(int i=0;i<lista.size();i++) {
            System.out.println(lista.get(i));
        }
        /*b. Si en lugar de usar un ArrayList en el inciso anterior hubiera usado un LinkedList ¿Qué
            diferencia encuentra respecto de la implementación? Justifique*/
        LinkedList<Integer> lista2 = new LinkedList<Integer>();
        for(int i=0;i<n;i++) {
            lista2.add(scanner.nextInt());
        }
        for(int i=0;i<lista2.size();i++) {
            System.out.println(lista2.get(i));
        }
        // No hay diferencia en el uso de la implementación

        //c. ¿Existen otras alternativas para recorrer los elementos de la lista del punto 7a.?
        // Formas de recorrer los elementos de la lista
        // 1. Iterar sobre el indice
        /*
            for(int i=0;i<lista2.size();i++) {
                System.out.println(lista2.get(i));
            }
            // 2. Iterar sobre el elemento
            for(Integer i : lista2) {
                System.out.println(i);
            }
            // 3. Usar un Iterator
            Iterator<Integer> iterator = lista2.iterator();
            while(iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        */
        
        scanner.close();
    }
}
