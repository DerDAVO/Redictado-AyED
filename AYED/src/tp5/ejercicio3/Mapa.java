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
    /*
     * Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades
        que están contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista
        vacía. (Sin tener en cuenta el combustible).
    */
    // Para evitar que se agreguen o se hagan otro tipo de consultas sobre un vertice que no debe tenerse en cuente(esta en la lista de exeptuados)
    // podemos hacer uso de un metodo que nos marque como ya visitados a estos vertice asi implementamos el codigo del ejercicio anterior
    // 
    private void marcarExeptuados(List<String> ciudades,boolean[] marca){
        for (String aux : ciudades) {
            Vertex<String> v = grafo.search(aux);
            if(v!=null){
                marca[v.getPosition()]=true;
            }
        }
    }
    public List<String> devolverCaminoExeptuando(String ciudad1,String ciudad2,List<String> ciudades){
        List<String> res = new LinkedList<>();
        if(!grafo.isEmpty()){
            Vertex<String> c1 = grafo.search(ciudad1);
            Vertex<String> c2 = grafo.search(ciudad2);
            boolean[] marca = new boolean[grafo.getSize()]; 
            if(c1 != null && c2 != null){
                List<String> aux = new LinkedList<>();
                marcarExeptuados(ciudades, marca);
                devolverCamino(grafo, res, aux, marca,c1.getPosition(), c2);
            }
        }
        return res;
    }
    
    
    /*Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a ciudad2, si no
        existe camino retorna la lista vacía. (Las rutas poseen la distancia).*/
    
    public List<String> caminoMasCorto(String ciudad1,String ciudad2){
        List<String> camino = new LinkedList<>();
        if(!grafo.isEmpty()){
            Vertex<String> c1 = grafo.search(ciudad1);
            Vertex<String> c2 = grafo.search(ciudad2);
            if(c1 != null && c2 != null){
                boolean[] marca = new boolean[grafo.getSize()];
                caminoMasCorto(grafo,marca,camino,new LinkedList<String>(),c1.getPosition(),c2,0,Integer.MAX_VALUE);
            } 
        }
        return camino;
    }
    private int caminoMasCorto(Graph<String> grafo, boolean[] marca, List<String> camino,
        LinkedList<String> aux, int position, Vertex<String> c2,int total,int minimo) {
        
        marca[position]=true;
        Vertex<String> actual = grafo.getVertex(position);
        // Sie encuentro un camino mas corto remuevo el anterior
        if(actual.getData().equals(c2.getData()) && total < minimo){
            camino.removeAll(camino);
            camino.addAll(aux);
            minimo=total; // Actualizo el total
        }else{
            // Si no es el destino tengo que seguir buscando
            // por lso demas vertices
            List<Edge<String>> aristas = grafo.getEdges(actual);
            Iterator<Edge<String>> it = aristas.iterator();
            // hay vertices por visitar y no sobrepsan el camino minimo
            // NO tendria sentido seguir buscando 
            while(it.hasNext() && total < minimo){
                Edge<String> arista = it.next();
                int posNext = arista.getTarget().getPosition();
                int acumulador = total + arista.getWeight();
                if(marca[posNext]== false && acumulador < minimo){
                    minimo = caminoMasCorto(grafo, marca, camino, aux, posNext, c2, acumulador, minimo);
                }
            }
        }
        marca[actual.getPosition()]=false;
        aux.remove(aux.size()-1);
        return minimo;
    }
}
