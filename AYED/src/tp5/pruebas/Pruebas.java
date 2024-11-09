package tp5.pruebas;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjMatrix.AdjMatrixGraph;

public class Pruebas {
    public static void main(String[] args) {
        System.out.println("Pruebas");
        Graph<Integer> g = new AdjMatrixGraph<>(10);
        Vertex<Integer> v = g.createVertex(1);
        Vertex<Integer> v2 = g.createVertex(2);
        g.connect(v, v2);
        g.connect(v2, v);
        System.out.println(g.getEdges(v).size());
        System.out.println(g.getEdges(v2).size());
        System.out.println(g.getSize());
    }
}
