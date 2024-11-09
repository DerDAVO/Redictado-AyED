package tp5.ejercicio2;


import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Recorridos<T> {

    // Retorna una lista con los datos de los vertices , con el recorrido en profundidad del grafo recibido por parametro.
    public  List<T> dfs(Graph<T> grafo){
        boolean[] marca = new boolean[grafo.getSize()];// Creo un vector de marcas con la cantidad
        // de vertices en el grafo
        List<T> res = new LinkedList<>();
        // Itero por cada vertice que no fue visitado
        for(int i=0;i<grafo.getSize();i++){
            if(marca[i]== false){
                dfs(i,marca,grafo,res);
            }
            
        }
        return res;
    }
    private void dfs(int i , boolean[] marca, Graph<T> grafo,List<T> res){
        // Hago lo necesario para saber si el vertice en el que estoy
        marca[i]=true;// Ya entre a la recursion asi que lo marco como visitado
        Vertex<T> actual = grafo.getVertex(i); // Me traigo el vertice actual 
        res.add(actual.getData());// agrego el dato del vertice actual

        List<Edge<T>> aristas = grafo.getEdges(actual); // Le pido al grafo las aristas que tiene actual
        
        for(Edge<T> edge : aristas){// itero sobrea cada arista para ver si puedo visitar los vertices adyacentes a actual
            int posNext = edge.getTarget().getPosition(); // A la arista actual le pedio la posicion del vertice destino
            if(marca[posNext]==false){
                dfs(posNext,marca,grafo,res);
            }    
        }
    }

    //--------------------------------------------------------------------------------------------------
    // Retorna una lista con los datos de vertices con el recorrido en amplitud de grafo recibido por parametro
    // Es casi los mismo el que el DFS solo que usa una cola para recorrer todos los adyaentes del nodo actual
    //, y luego pasar al siguiente nivel 
    public List<T> bfs(Graph<T> grafo){
        boolean[] marca = new boolean[grafo.getSize()];
        List<T> res = new LinkedList<>();
        for(int i=0;i<grafo.getSize();i++){
            if(marca[i]==false){
                bfs(i,marca,grafo,res);
            }            
            
        }
        return res;
    }         
    // Por lo que entendi se van encolando los adyacentes del vertice actual sacado de la cola
    // tomo sus adyacentes y si no fueron visitados los agrego a la cola para que sean analizados
    // en la proxima iteracion del while que controla la cola 
    private void bfs(int i, boolean[] marca, Graph<T> grafo, List<T> res) {
        
        marca[i]=true;// marco el actual como visitado
        Queue<Vertex<T>> cola = new Queue<>();
        cola.enqueue(grafo.getVertex(i));
        while(!cola.isEmpty()){
            Vertex<T> actual= cola.dequeue(); // Desencolo el vertice acual   
            res.add(actual.getData());// Agrego el dato de el vertice actul a la lista 
            List<Edge<T>> aristas = grafo.getEdges(actual);// Tomo sus adyacentes
            for (Edge<T> edge : aristas) {
                // Itero sobre cada arista de actual
                int posNext = edge.getTarget().getPosition();
                if(marca[posNext]== false){
                    cola.enqueue(grafo.getVertex(posNext));
                    marca[posNext]=true;
                }
            }

        }
    }
                
}
