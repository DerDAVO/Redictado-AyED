## Tiempo de ejecucion
### Dado el siguiente algoritmo calcule el T(n) correspondiente
``` java
    public int met(int n){
        int c= ;
        if(n >= 2){
            c += met(n-1)*met(n-1)+n;
        }
        return c;
    }
```
En este caso al hacer 2 llamados el orden queda como O(2^n) orden exponencial
### a) Expresar la funcion de T(n) del siguiente metodo(no es necesario desarrollar)
``` java
    public static void calculo(int n){
        int i,j,k,x=0;
        for(i=1;i<=n;i=i*2){
            for(j=n;j>=1;j=j-2){
                for(k=0;k<=n;k++){
                    x=x*2;
                }
            }

        }
    }
```
b) Expresar el O(n) del metodo del inciso anterior(no es necesario justificar)