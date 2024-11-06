# Apuntes de algoritmos DFS y BFS
## Depth First Search
### Funcionamiento 
Recorrido de forma general del recorrido en preorden de un arbol 
### Pasos basicos 
1. Marcar todos los vertices como visitados.
2. Elegir vertice **u** como visitado.
3. Marcar **u** como visitado.
4. Para cada vertice adyacenta a **u** que no haya sido visitado, repetir recursivamente los pasos 3 y 4.
- Finalizar cuando se hayan visitado todos los nodos alcanzables desde u.
- Si desde u no fueron alcanzables todos los nodos del grafo: volver a (2), elegir un nuevo vertice de partida **v** no visitado y repetir el proceso hasta que no queden vertices sin visitar.
### Cuando usar DFS
+ Cuando se necesta un camino completo antes de ver otras alternativas
+ Util en problemas como
    + Encontrar caminos(o todos los caminos) entre dos nodos
    + Detectar ciclos en grafos
    + Resolver laberintos
    + Problemas de backtracking
### Implementacion DFS en java

``` java
    public void dfs(Graph<T> grafo){
        boolean[] marca = new boolean[grafo.getsize()];
        // Este for itera sobre todos los vertices del grafo que no han sido visitados (no son alcanzados por el DFS ejecutado desde el vertices i-1)
        for(int i = 0; i < grafo.getsize(); i++){
            if(!marca[i]){//Si no esta visitado
                System.out.println("Dato : "+ grafo.getVertex(i).getData());
                dfs(i,grafo,marca); // Paso la llamada recursiva al siguiente vertice no visitado
            }
            
        }
        // En la llamada a DFS tengo que mandar el grafo completo ya que no hay otra forma de acceder a los demas vertices del grafo
    }


    private void dfs(int i,Graph<T> grafo,boolean[] marca){
        marca[i] = true;
        Vertex<T> v = grafo.getVertex(i);
        List<Edge<T>> adyacentes = grafo.getEdges(v);  
        for(Edge<T> e : adyacentes){
            int j = e.getTarget().getPosition();
            if(!marca[j]){
                dfs(j,grafo,marca);
            }
        }
        // Al crear la lista de adyacentes del grafo actual estoy obteniendo las aritas de que me indican los proxios nodos a visitar
        // Cuando recorremos la lista de vertices accedemos a cada uno de los vertices adyacetes del vetice actual
    }

```
## Breath First Search
### Funcionamiento
+ BFS explora todos los nodos del nivel actual antes de pasar al siguiente nivel mas profundo.
+ Utiliza una cola FIFO para mantener el orden en el que fue avanzando sobra el grafo.
### Pasos basicos(esquema iterativo)
1. Encolar el vertice origen **u**.
2. Marcar el vertice **u** como visitado.
3. Procesar la cola.
4. Desencolar **u** de la cola.
5. Para cada adyacente **v** de **u**.
6. Si **v** no ha sido visitado.
7. Encolar y visitar.

- Si desde **u** no fueron alcanzados todos los nodos del grafo: volver a (1), elegir un nuevo vertice de partida no visitado, y repetir el proceso hasta que se hayan recorrido todos los vertices.
### Cuando usar BFS
+ Cuando se necesita encontrar el camino mas corto en un grafo no pesado
+ Util en problemas como :
    + Determinar la distancia minima entre dos nodos.
    + Encontrar de cada nodo desde la raiz en un arbol o grafo.
    + Resolver problemas de conectividad
    + Exploracion por niveles en juegos o problemas de deciciones.
### Implementacion BFS en java

``` java
    public static void bfs(Graph<T> grafo){
        //Implementacion de BFS
        boolean[] marca = new boolean[grafo.getsize()];
        for(int i = 0; i < grafo.getsize(); i++){
            if(!marca[i]){
                bfs(i,grafo,marca);
            }
        }
        private static void bfs(int i,Graph<T> grafo,boolean[] marca){
            Queue<Vertex<T>> cola = new Queue<Vertex<T>>();
            cola.enqueue(grafo.getVertex(i));
            marca[i] = true;
            while(!cola.isEmpty()){
                Vertex<T> v = cola.dequeue();
                System.out.println("Dato : "+ v.getData());
                List<Edge<T>> lista = grafo.getEdges(v);
                for(Edge<T> e : lista){
                    int j = e.getTarget().getPosition();
                    if(!marca[j]){
                        marca[j] = true;
                        cola.enqueue(grafo.getVertex(j));
                    }
                }
            }
        }

    }
```
## Ejercicios de parcial

```java
    // En caso de que se aclare que los destinos y origen deben ser buscados puedo usar el metodo search
    // para el caso de Vertex<String> , pero si son de otro tipo debo implementar el metodo search correspondiente al tipo
    // de dato que tenga el grafo (conveniente buscar destino y origen en el mismo recorrido,no en diferentes metodos)
    
    // En caso de tener la necesida de preservar datos primitivos en el recorrido del grafo
    // puedo usar un clase que contenga los datos que quiero preservar, si solo necesito presevar un dato
    // pudeo usar un return 
    // Hay otros casos en los que me sirve que los primitivos pierdan su valor 

    public class ParcialGrafos{
        public List<String> recirridoSeguroMaxFrutales(Graph<String> bosque,String caperucita,String abuelita,int maxFrtuales)
          List<String> resultado = new List<String>();  
          Vertex<String> origen = bosque.search(caperucita);
          if(origen!=null){
              dfs(maxF,o,d,resultado,new List<String>(),new boolean[],abuelita,origen.getPosition());
          }

    }
    // En caso de detener la recursion antes debemos usar un iterator
    public int dfs(int maxF,origen,destino,List<String> resultado,List<String> lista,boolean[] marca,String abuelita,int posV){
        Vertex<String> vertice = bosque.getVertex(i);
        marca[posV] = true;
        caminoAct.add(vertice.getData());
        if(vertice.getData().equals(abuelita)){
            if(frutAct >= frutMax){
                frutAct = frutMax;
                resultado.clear();
                resultado.addAll(caminoAct);
            }
        }else{
            List<Edge<String>> adyacentes = bosque.getEdges(vertice);
            for(Edge<String> e : adyacentes){
                int j = e.getTarget().getPosition();
                if(!marca[j]){
                   frutMax = dfs(maxF,frutActual,peso,frutMax,resultado,comminoActual,marca,abuelita,j);
                }
            }
        }
        marca[posV] = false;
        caminoAct.remove(caminoAct.size()-1);
        return frutMax;
    }

```