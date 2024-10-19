package tp1.ejercicio7;
import java.util.List;
import java.util.ArrayList;
public class EjercicioSucesion {
    // 7.Escriba un programa recursivo que, a partir de un número n, devuelva una lista
    //con cada miembro de la sucesión.
    
    private static void recursion(int n,List<Integer> lista){
        if(n!=1){
            if(n % 2 == 0){
                lista.add(n);
                recursion(n/2,lista);
            }else{
                lista.add(n);                
                recursion(3*n+1,lista);
            }
        }else{
            lista.add(n);
        }
    }
    public static List<Integer> calcularSucesion(int n){
        List<Integer> lista = new ArrayList<Integer>();
        recursion(n,lista);
        return lista;
    }
    public static void main(String[] args) {
        System.out.println(EjercicioSucesion.calcularSucesion(6));
    }
}
