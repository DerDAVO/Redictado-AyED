import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Ejercicio6<T>{
    private Graph<T> bosque;

/* Ejercicio 6
Un día, Caperucita Roja decide ir desde su casa hasta la de su abuelita, recolectando frutos del bosque del
camino y tratando de hacer el paseo de la manera más segura posible. La casa de Caperucita está en un claro
del extremo oeste del bosque, la casa de su abuelita en un claro del extremo este, y dentro del bosque entre
ambas hay algunos otros claros.
El bosque está representado por un grafo, donde los vértices representan los claros (identificados por un
String) y las aristas los senderos que los unen. Cada arista informa la cantidad de árboles frutales que hay en el
sendero. Caperucita sabe que el lobo es muy goloso y le gustan mucho las frutas, entonces para no ser
capturada por el lobo, desea encontrar todos los caminos que no pasen por los senderos con cantidad de
frutales >= 5 y lleguen a la casa de la abuelita.
Su tarea es definir una clase llamada BuscadorDeCaminos, con una variable de instancia llamada "bosque" de
tipo Graph, que representa el bosque descrito e implementar un método de instancia con la siguiente firma:
public List < List <String>> recorridosMasSeguro()
que devuelva un listado con TODOS los caminos que cumplen con las condiciones mencionadas anteriormente.
Nota: La casa de Caperucita debe ser buscada antes de comenzar a buscar el recorrido.
Para el siguiente ejemplo:
Debe retornar una lista con caminos:
1) Casa Caperucita- Claro 1 - Claro 5 - Casa Abuelita.
2) Casa Caperucita- Claro 2 - Claro 1 - Claro 5 - Casa Abuelita. */

    public List<List<String>> recorridosMasSeguro(){
        List<String> aux = new LinkedList<>();
        List<List<String>> res = new LinkedList<>();

        boolean[] marca = new boolean[bosque.getSize()];
        if(bosque==null){
            return res;
        }  
        Vertex<String> origen=bosque.search("Casa caperucita");
        Vertex<String> destino= bosque.search("Casa abuelita");
        if((origen!=null)&&(destino!=null)){
            dfs(marca,bosque,origen.getPosition(),destino.getData(),res,aux);
        }
        return res;
    }
    private void dfs(boolean[] marca,Graph<T> bosque,int posOrigen,String destino,List<List<String>> res,List<String> aux){
        marca[posOrigen]=true;
        Vertex<T> actual = bosque.getVertex(posOrigen);
        if(actual.getData().equals(destino)){
                res.add(new LinkedList<>(aux));
        }else{
            List<Edge<T>> ady = bosque.getEdges(actual);
            for(Edge<T> arista : ady){
                int proximo = arista.getTarget().getPosition();
                if(!marca[proximo] && arista.getWeight() < 5){
                    dfs(marca, bosque, proximo, destino, null, aux);
                }
            }
        }
        marca[posOrigen]=false;
        aux.remove(aux.size()-1);
    }

}