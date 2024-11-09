package tp5.ejercicio3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Mapa<T> {

    private Graph<String> grafo;
    
    public Mapa(){

    }
    
    // Retorna la lista de ciudades que se deben atravezar para ir de ciudad1 a ciudad2 
    // en caso de que se pueda llegar, si no retorna la lista vacia.(sin tener en cuente el combustible)
    
    public List<String> devolverCamino(String ciudad1,String ciudad2){
        //Primero ver que el grafo tenga verticesy luego ver que las ciudades existan en el grafo
        List<String> res = new LinkedList<>();
        
        // En este caso no hace falta iterar sobra cada vertice no visitado del grafo
        // ya que solo tenemos que buscar desde el origen y el enunciado especifica que
        // puede no haber camino 
        if(!grafo.isEmpty()){
            Vertex<String> c1 = grafo.search(ciudad1);
            Vertex<String> c2 = grafo.search(ciudad2);
            if((c1 != null) && (c2 != null)){
                List<String> aux = new LinkedList<>();
                devolverCamino(this.grafo,res,aux,new boolean[grafo.getSize()],c1.getPosition(),c2);
            }
        }
        return res;
    }    
    private void devolverCamino(Graph<String> grafo,List<String> res,List<String> aux,boolean[] marca,int pos,Vertex<String> destino){
        marca[pos]=true;
        Vertex<String> actual = grafo.getVertex(pos);
        aux.add(actual.getData());// Voy armando el camino
        if(actual.getData().equals(destino.getData())){
            //termino la recursion copiando el camino
            res.addAll(aux);
        }else{
            List<Edge<String>> aristas = grafo.getEdges(actual);// Tomo las aristas del vertice actual
            Iterator<Edge<String>> iterator = aristas.iterator();
            while (iterator.hasNext() && res.isEmpty()) {
                int posNext = iterator.next().getTarget().getPosition();// Obetngo la posicion del proximo vertice a visitar
                if(marca[posNext]==false){
                    devolverCamino(grafo, res,aux, marca, posNext, destino);
                }
            }
            
        }
    }
}
