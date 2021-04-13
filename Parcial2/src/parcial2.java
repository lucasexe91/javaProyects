public class parcial2 {
    final static int MAXFILAS = 5;
    final static int MAXCOLUMNAS = 7;
    final static char letra1='l';
    final static char letra2='o';
    final static char letra3='b';
    public static void main(String[] args) {
        int contador_caracteres =0;
        int contador_vocales=0;
        char matriz[][] = new char[MAXFILAS][MAXCOLUMNAS];
        cargar_matriz_aleatorio_secuencias_char(matriz);
        imprimir_matriz_char(matriz);
        contador_caracteres = (contar_letras(matriz));
        contador_vocales = (contar_vocales(matriz));
        if (contador_caracteres > contador_vocales){
            matriz = buscar_e_invertir(matriz);
        }
        imprimir_matriz_char(matriz);
    }
    static public char[] invertir_array(char[] array){
        char aux;
        for (int i = 0; i < MAXCOLUMNAS / 2; i++) {
            aux = array[i];
            array[i] = array[MAXCOLUMNAS - 1 - i];
            array[MAXCOLUMNAS- 1 - i] = aux;
        }
        return array;
    }
    static public char[][] buscar_e_invertir(char[][]mat){
        for (int fila=0; fila<MAXFILAS; fila++){
            if (verificar_secuencia_impar(mat[fila])){
                mat[fila] = invertir_array(mat[fila]);   
            }
        }
        return mat;
    }
    static boolean verificar_secuencia_impar(char[]array){
        int cont = 0;
        for (int columna=0;columna<MAXCOLUMNAS;columna++){
            if (array[columna] != ' '){
                cont ++;
            }
        }
        return cont % 2 == 0;
    }
    static int contar_vocales(char[][] mat){
        int contador=0;
        for (int fila=0; fila<MAXFILAS; fila++){
            for (int columna=0; columna<MAXCOLUMNAS; columna++){
                if (comparar_chars(mat[fila][columna],'a')||comparar_chars(mat[fila][columna],'e')||comparar_chars(mat[fila][columna],'i')||comparar_chars(mat[fila][columna],'o')||comparar_chars(mat[fila][columna],'u')){
                    contador++;
                }
            }
        }
        return contador;
    }
    static int contar_letras(char [][] mat){
        int contador= 0;
        int contadorletra1= 0;
        int contadorletra2= 0;
        int contadorletra3= 0;
        for (int fila=0; fila<MAXFILAS; fila++){
            for (int columna=0; columna<MAXCOLUMNAS; columna++){
                if (comparar_chars(mat[fila][columna],letra1)){
                    contadorletra1++;
                }
                if (comparar_chars(mat[fila][columna],letra2)){
                    contadorletra2++;
                }
                if (comparar_chars(mat[fila][columna],letra3)){
                    contadorletra3++;
                }
            }
        }
        System.out.println("la cantidad de " + letra1 + " fue de: " + contadorletra1);
        System.out.println("la cantidad de " + letra2 + " fue de: " + contadorletra2);
        System.out.println("la cantidad de " + letra3 + " fue de: " + contadorletra3);
        return contador= contadorletra1+contadorletra2+contadorletra3;
    }
    static boolean comparar_chars(char char1, char char2){
        return char1 == char2;
    }
    static public void cargar_matriz_aleatorio_secuencias_char(char [][] mat){
        for (int fila = 0; fila < MAXFILAS; fila++){
            cargar_array_random_char(mat[fila]);
        }
        System.out.println("");
    }
    static public void imprimir_matriz_char(char [][] mat){
        for (int fila = 0; fila < MAXFILAS; fila++){
            imprimir_arreglo_char(mat[fila]);
            System.out.println("");
        }
    }
    static public void imprimir_arreglo_char(char []arr){ //imprime un arreglo de chars
        for (int i = 0; i < MAXCOLUMNAS; i++){
            System.out.println("");
        }
    }
}
