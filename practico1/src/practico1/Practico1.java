package practico1;
public class Practico1 {
    final static int MAX = 5;
    final static int MAXFILA =5;
    final static int MAXCOLUMNA = 5;
    public static void main(String[] args) {
        int col = 5;
    }

    private static float promedioDeUnArray(int[] arr){ 
        int suma=0;
        for (int pos=0;pos<MAX;pos++) {
            suma +=arr[pos];
        }
        return (suma/MAX);
    }
    private static void cargar_array_random4(int[] arr) { //carga un array con numeros random del 1 al 4
        for (int pos = 0 ; pos < MAX; pos++)
            arr[pos]=(int) (Math.random() * 4);
    }

    private static int buscar_pos_desordenado(int[] arr,int valor) { //busca una posicion en un array desordenado
        int pos = 0;
        while ((pos<MAX)&&(arr[pos]!=valor)){
            pos++;
        }
        if (pos<MAX)
            return pos;
        else
            return -1;
    }
    private static int buscar_pos_ordenado(int[] arr,int valor){ //busca una posicion en un array ordenado
        int pos = 0;
        while ((pos<MAX)&&(arr[pos]>valor)) {
            pos++;
        }
        if ((pos<MAX)&&(arr[pos]==valor))
            return pos;
        else
            return -1;
    }
    public static void seleccion(int arr[]) {  //metodo de ordenamiento por seleccion
        int i, j, menor, pos, tmp;
        for (i = 0; i < MAX; i++) { // tomamos como menor el primero
            menor = arr[i]; // de los elementos que quedan por ordenar
            pos = i; // y guardamos su posición
            for (j = i + 1; j < MAX; j++){ // buscamos en el resto
                if (arr[j] < menor) { // del array algún elemento
                    menor = arr[j]; // menor que el actual
                    pos = j;
                }
            }
            if (pos != i){ // si hay alguno menor se intercambia
                tmp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = tmp;
            }
        }
    }
    public static void insercion(int arr[]){ //metodo de ordenamiento por insercion
        for (int i = 1; i < MAX; i++) {
            int aux = arr[i];
            int j = i - 1;
            while ((j >= 0) && (arr[j] > aux)){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = aux;
        }
    }
    public static void burbujeo(int[] arr){ //metodo de ordenamiento por burbujeo
        int temp;
        for(int i = 1;i < MAX;i++){
            for (int j = 0 ; j < MAX - 1; j++){
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    
    public void imprimir_promedios_filas (int[][] mat){ //imprime el promedio de filas sin arreglo
        for (int fila = 0 ; fila < MAXFILA; fila++){
            System.out.println("Promedio de la fila "+fila+" es "+promedio_fila(mat,fila));
        }
    }
    public int promedio_fila (int[][] mat, int fila){ //saca el promedio de las filas de un array sin arreglo
        int promedio;
        int suma = 0;
        for (int columna = 0 ; columna < MAXCOLUMNA; columna++) {
            suma+=mat[fila][columna];
        }
        promedio = suma/MAXCOLUMNA;
        return promedio;
    }
    
    public void imprimir_promedios_filas_con_array (int[][] mat){ //imprime el promedio de filas con arreglo
        for (int fila = 0 ; fila < MAXFILA; fila++){
            System.out.println("Promedio de la fila "+fila+" es "+promedio_arreglo(mat[fila]));
        }
    }
    public int promedio_arreglo (int[] arr){ //saca el promedio de las filas de un array con arreglo
        int promedio;
        int suma = 0;
        for (int columna = 0 ; columna < MAXCOLUMNA; columna++) {
            suma+=arr[columna];
        }
        promedio = suma/MAXCOLUMNA;
        return promedio;
    }
    
    public void imprimir_promedios_matriz (int[][] mat){ //promedio de cada columna de la matriz
        int promedio;
        for (int col = 0 ; col < MAXCOLUMNA; col++){
            System.out.println("Promedio de la columna "+col+" es "+obtener_promedio_columna(mat,col));
        }
    }
    public int obtener_promedio_columna(int[][] mat, int col){ //promedio de columnas
        int promedio; int suma = 0;
        for (int fila = 0 ; fila < MAXFILA; fila++) {
            suma+=mat[fila][col];
        }
        promedio = suma/MAXCOLUMNA;
        return promedio;
    }
    
    public void ordenar_matriz_columna_seleccion(int [][] mat, int col){ //ordena una matriz por columna por seleccion
        int pos_menor, tmp;
        for (int i = 0; i < MAXFILA; i++) {
            pos_menor = i;
            for (int j = i + 1; j < MAXFILA; j++){
                if (mat[j][col] < mat[pos_menor][col]) {
                    pos_menor = j;
                }
            }
            if (pos_menor != i){
                tmp = mat[i][col];
                mat[i][col] = mat[pos_menor][col];
                mat[pos_menor][col] = tmp;
            }
        }
    }
    public void imprimir_arreglo_char(char []arr){ //imprime un arreglo de chars
        for (int i = 0; i < MAX; i++){
            System.out.println("");
        }
    }
    public void imprimir_arreglo_int(int []arr){ //imprime un arreglo de ints
        for (int i = 0; i < MAX; i++){
            System.out.println("");
        }
    }
    public void imprimir_matriz_char(char [][] mat){ //imprime una matriz de chars
        for (int fila = 0; fila < MAXFILA; fila++){
            imprimir_arreglo_char(mat[fila]);
            System.out.println("");
        }
    }
    public void imprimir_matriz_int(int [][] mat){ //imprime una matriz de ints
        for (int fila = 0; fila < MAXFILA; fila++){
            imprimir_arreglo_int(mat[fila]);
            System.out.println("");
        }
    }
    public void cargar_matriz_aleatorio_secuencias_int(int [][] mat){ //carga una matriz de ints random (llamando a cargar_array_random4)
        for (int fila = 0; fila < MAXFILA; fila++){
            cargar_array_random4(mat[fila]);
        }
        System.out.println("");
    }
    public void cargar_matriz_aleatorio_secuencias_char(char [][] mat){ //carga una matriz de chars random
        for (int fila = 0; fila < MAXFILA; fila++){
            cargar_array_random_char(mat[fila]);
        }
        System.out.println("");
    }
    private static void cargar_array_random_char(char[] arr) { //carga un array con chars random 
        int tmp;
        for (int pos = 0 ; pos < MAX; pos++){
            tmp = (int) (Math.random() * 26);
            arr[pos]=((char)tmp);
        }       
    }
    
    public void corrimiento_derecha(int [] arrenteros, int pos, int maxarray){ //teniendo un array de enteros, la posicion y el maximo, corre el array a la derecha
        int indice = maxarray-1;
        while (indice > pos){
            arrenteros[indice] = arrenteros[indice-1];
            indice--;
        }
    }

}
