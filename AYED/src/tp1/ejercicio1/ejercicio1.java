
package tp1.ejercicio1;
/*1. Escriba tres métodos de clase (static) que reciban por parámetro dos números enteros (tipo
int) a y b e impriman todos los números enteros comprendidos entre a; b (inclusive), uno por
cada línea en la salida estándar. Para ello, dentro de una nueva clase escriba un método por
cada uno de los siguientes incisos:
a. Que realice lo pedido con un for.
b. Que realice lo pedido con un while.
c. Que realice lo pedido sin utilizar estructuras de control iterativas (for, while, do
while).
Por último, escriba en el método de clase main el llamado a cada uno de los métodos
creados, con valores de ejemplo. En su computadora, ejecute el programa y verifique
que se cumple con lo pedido.
 */
public class ejercicio1 {

    public static void imprimirNumerosEntreConFor(int a, int b) {
        for (int i=a; i<=b; i++) {
            System.out.println(i);
        }
    }
    public static void imprimirNumerosEntreConWhile(int a, int b) {
        while(a<=b){
            System.out.println(a);
            a++;
        }
    }
    public static void imprimirNumerosEntreConRecursion(int a, int b) {
        if(a<=b){
            System.out.println(a);
            imprimirNumerosEntreConRecursion(a+1, b);
        }
    }
    public static void main(String[] args) {
        ejercicio1.imprimirNumerosEntreConRecursion(1, 3);
        ejercicio1.imprimirNumerosEntreConFor(1, 3);
        ejercicio1.imprimirNumerosEntreConWhile(1, 3);
    }
}
