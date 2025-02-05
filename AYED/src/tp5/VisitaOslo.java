 package tp5;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class VisitaOslo<T> {
    public void marcarLugaresRestringidos(boolean[] marca,List<String> lugaresRestringidos,Graph<String> lugares){
        for(String lugar : lugaresRestringidos){
            Vertex<String> v = lugares.search(lugar);
            marca[v.getPosition()]=true;
        }
    }

    public List<String> paseoEnBici(Graph<String> lugares,String destino,int maxTiempo,List<String> lugaresRestringidos){
        List<String> res = new LinkedList<>();
        if(lugares==null){
            return res;
        }
        Vertex<String> origen = lugares.search(destino);
        if(origen!=null){
            List<String> aux = new LinkedList<>();
            boolean[] marca = new boolean[lugares.getSize()];
            marcarLugaresRestringidos(marca,lugaresRestringidos,lugares);
            dfs(maxTiempo,0,origen.getPosition(),destino,lugares,marca,aux,res);
        }
        return res;
    }
    // Usar objeto para almacenar el tiempo total?
    //Puede usar objetos extra para almacenar valores que se modifican a lo largo
    // de la recursion
    private boolean dfs(int maxT,int total,int posOrigen,String destino,Graph<String> lugares,boolean[] marca,List<String> aux,List<String> res){
        boolean encontre=false;
        marca[posOrigen]=true;
        Vertex<String> v = lugares.getVertex(posOrigen);
        if(v.getData().equals(destino)){
            res = new LinkedList<>(aux);
             return true;
        }else{
            Iterator<Edge<String>> it = lugares.getEdges(v).iterator();
            while((!encontre)&&(it.hasNext())){
                Edge<T> arista = it.next();
                if((!marca[arista.getTarget().getPosition()])&&(maxT > total+arista.getWeight())){
                    encontre=dfs(maxT, total+arista.getWeight(), posOrigen, destino, lugares, marca, aux, res);
                }
            }
        }
        aux.remove(aux.size());//Para desarmar la lista en caso de que no me sirva el recorrido
        marca[posOrigen]=false;
    }
}  