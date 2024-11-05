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
