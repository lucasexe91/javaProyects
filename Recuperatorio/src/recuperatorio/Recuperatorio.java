
package recuperatorio;

import java.util.Scanner;

public class Recuperatorio {
final static int FILAS = 10;
final static int COLUMNAS = 5;
    public static void main(String[] args) {
       char M[][] = new char [FILAS][COLUMNAS];
       mostrarMatriz(M);
       if (cuentaSecuencias(M)){
           Scanner lector = new Scanner(System.in);
           int x =0;
           do{
               System.out.println("ingrese X");
               x=lector.nextInt();
           }while (x<=0);
           searchAndDestroy(M,x);
           mostrarMatriz(M);
       }
    }
    public static boolean cuentaSecuencias(char [][] mat){
        int contOrdenadas = 0;
        int contDesordenadas = 0;
        for (int i = 0; i < FILAS; i++) {
	int inicio = 0;
	int fin = 0;
            while (inicio < COLUMNAS && fin < COLUMNAS) {
                inicio = buscarInicio(mat[i], fin);
                    if (inicio < COLUMNAS) {
                        fin = buscarFin(mat[i], inicio);
                        if (fin < COLUMNAS) {
                            if (secuenciaOrdenada(mat[i], inicio, fin)) {
                                contOrdenadas++;
                            }else{
                                contDesordenadas++;
                            }
                        }
                    }
                fin++;
            }
	}
        System.out.println("la cantidad de secuencias ordenadas alfabeticamente es: "+contOrdenadas);
        System.out.println("la cantidad de secuencias desordenadas es: "+ contDesordenadas);
    return contOrdenadas > contDesordenadas;
    }
    public static boolean secuenciaOrdenada(char[] fila, int inicio, int finSecuencia) {
        for(int i=inicio; i < finSecuencia-1 ; i++){
            if (fila[i]>fila[i+1]){
                return false;
            }
        }
	return true;
    }
    public static int buscarFin(char[] fila, int pos) { 
	while (pos < COLUMNAS && fila[pos] != ' ') {
            pos++;
	}
	if (pos < COLUMNAS) {
            return pos - 1;
	} else {
            return pos;
	}
    }

    public static int buscarInicio(char[] fila, int pos) { 
	while (pos < COLUMNAS && fila[pos] == ' ') {
            pos++;
	}
        return pos;
    }
    public static void searchAndDestroy (char [][]mat, int x){
        for (int i = 0; i < FILAS; i++) {
	int inicio = 0;
	int fin = 0;
            while (inicio < COLUMNAS && fin < COLUMNAS) {
                inicio = buscarInicio(mat[i], fin);
                    if (inicio < COLUMNAS) {
                        fin = buscarFin(mat[i], inicio);
                        if (fin < COLUMNAS) {
                            if (cuentaConsonantes(mat[i], inicio, fin)== x) {
                                destroy(mat[i],inicio, fin);
                            }
                        }
                    }
                fin++;
            }
	}
    }
    public static int cuentaConsonantes(char []arr,int inicio, int fin){
        int cont = 0;
        for(int i=inicio;i<fin; i++){
            if(esConsonante(arr[i])){
                cont++;
            }
        }
        return cont;
    }
    public static boolean esConsonante(char letra){
        return !(letra == 'a' ||letra == 'e' ||letra == 'i' ||letra == 'o' ||letra == 'u');
    }
    
    public static void destroy(char[] fila, int inicio, int fin) {
	for(int i=inicio;i<=fin;i++){
            corrimientoIzquierda(fila,inicio);
	}
    }

    public static void corrimientoIzquierda(char[] fila, int pos) {
    	while(pos<COLUMNAS-1){
            fila[pos]=fila[pos+1];
            pos++;
	}		
    }
    static void mostrarMatriz(char[][] matriz){
        for(int x=0; x < matriz.length; x++) {
            for(int y=0; y < matriz[x].length; y++) {
                System.out.print(matriz[x][y]);
                System.out.print(" | ");
            }
            System.out.println("");
        }
    }
}
