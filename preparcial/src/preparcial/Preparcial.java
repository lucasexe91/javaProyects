//Dada una matriz de MxN de enteros con secuencias separadas por ceros (0) contar e 
//informar la cantidad de secuencias que están en orden ascendente. Pedir al usuario 
//el ingreso de un número X entre 1 y 10. Si la cantidad de secuencias es múltiplo 
//de X, invertir la X secuencia.
//Todas las secuencias empiezan y terminan con uno o más ceros obligatoriamente.
//Usar constantes y buenas prácticas
package preparcial;

import java.util.Scanner;

public class Preparcial {
    final static int MAXFILAS = 10;
    final static int MAXCOLUMNAS = 5;
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int count=0;
        int num;
        int M[][] = { { 0, 1, 2, 0, 2 }, { 0, 2, 0, 3, 0 }, { 0, 4, 5, 6, 0 }, { 0, 2, 0, 3, 0 }, { 0, 1, 2, 0, 2 }, { 0, 2, 0, 3, 0 }, { 0, 4, 5, 6, 0 }, { 0, 2, 0, 3, 0 },{ 0, 1, 2, 0, 2 }, { 0, 2, 0, 3, 0 } };
        System.out.println("la matriz es:");
        imprimirMatriz(M);
        System.out.println("ingrese un numero del 1 al 10");
        num = lector.nextInt();
        for (int i = 0; i < MAXFILAS; i++) {	
            int inicio = 0;					
            int fin = 0;
            while (inicio < MAXCOLUMNAS && fin < MAXCOLUMNAS) {	
		inicio = buscarInicio(M[i], fin);	
		if (inicio < MAXCOLUMNAS) {		
                    fin = buscarFin(M[i], inicio);	
                    if (fin < MAXCOLUMNAS) {
                        if(esAscendente(M[i],inicio,fin)){
                            count++;
                            if(count % num == 0){
                                invertirXsecuencia(M[i],inicio,fin);
                            }
                        }
                    }
                }
                fin++;
            }    
        }
        System.out.println("la cantidad de secuencias ascendentes es de: "+count);
        if (count % num == 0){
            System.out.println(num+" es multiplo de " + count);
            System.out.println("la secuencia " + num + " fue invertida");
            imprimirMatriz(M);
        }else{
            System.out.println("su numero no es multiplo de "+ count);
        }  
    }
    public static int buscarFin(int[] fila, int pos) {
	while (pos < MAXCOLUMNAS && fila[pos] != 0) {
            pos++;
	}
        if (pos < MAXCOLUMNAS) {
            return pos - 1;
	} else {
            return pos;
	}
    }

    public static int buscarInicio(int[] fila, int pos) {
	while (pos < MAXCOLUMNAS && fila[pos] == 0) {
            pos++;
	}
            return pos;
    }
    public static boolean esAscendente(int [] array,int inicio,int fin){
        for( int i = inicio; i<fin-1;i++){
            if (array[i]>=array[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void invertirXsecuencia(int [] arr, int inicio, int fin){
        int aux;
        for(int j=inicio;j<fin/2;j++){
            aux = arr[j];
            arr[j] = arr[fin - 1 - j];
            arr[fin- 1 - j] = aux;
        }
    } 
                   
    public static void imprimirMatriz(int[][] M){
	for (int fila = 0; fila < MAXFILAS; fila++) {
            System.out.print("| ");
            for (int columna = 0; columna < MAXCOLUMNAS; columna++){
                System.out.print( M[fila] [columna] + " | ");
            }
            System.out.println();
	}
    }
}
