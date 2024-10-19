package tp1.ejercicio2;

import java.util.Scanner;

/*2. Escriba un método de clase que dado un número n devuelva un nuevo arreglo de tamaño n
con los n primeros múltiplos enteros de n mayores o iguales que 1.
Ejemplo: f(5) = [5; 10; 15; 20; 25]; f(k) = {n*k donde k : 1..k}
Agregue al programa la posibilidad de probar con distintos valores de n ingresandolos por
teclado, mediante el uso de System.in. La clase Scanner permite leer de forma sencilla
valores de entrada */
public class ejercicio2 {
    public static int[] vectorDeMultiplos(int n) {
		int[] multiplos = new int[n];
		for(int i =1; i <= n; i++) {
			multiplos[i-1]=i*n;
		}
		return multiplos;
	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número: ");
        int n = sc.nextInt();
        int[] vector = ejercicio2.vectorDeMultiplos(n);
        for(int i = 0; i < vector.length; i++) {
            System.out.println(vector[i]);
        }
        sc.close();
    }
}
