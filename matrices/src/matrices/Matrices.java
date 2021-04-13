package matrices;
public class Matrices {

    public static void main(String[] args) {
        int filas = 5;
        int columnas =3;
        int[][] matriz = new int [filas][columnas];
        iniciarMatrizCero(matriz);
        mostrarMatriz(matriz);
        aumentarUno(matriz);
        mostrarMatriz(matriz);
    }
    static void iniciarMatrizCero(int [][] matriz){
        for(int x=0; x < matriz.length; x++) {
            for(int y=0; y < matriz[x].length; y++) {
                matriz[x][y]= 0;
            }
        }
    }
    static void aumentarUno(int[][] matriz){
        for(int x=0; x < matriz.length; x++) {
            for(int y=0; y < matriz[x].length; y++) {
                matriz[x][y]++;
            }
        }
    }
    static void mostrarMatriz(int[][] matriz){
        for(int x=0; x < matriz.length; x++) {
            for(int y=0; y < matriz[x].length; y++) {
                System.out.print(matriz[x][y]);
                System.out.print(" | ");
            }
            System.out.println("");
        }
    }
    final static int FILAS = 4;
	final static int COLUMNAS = 5;
	final static int MAX_PATRON = 3;
		int M[][] = { { 0, 1, 2, 0, 2 }, { 0, 2, 0, 3, 0 }, { 0, 4, 5, 6, 0 }, { 0, 2, 0, 3, 0 } };
		int P[] = { 4, 5, 6 };

		for (int i = 0; i < FILAS; i++) {	//RECORREMOS LAS FILAS
			int inicio = 0;					//INICIALIZAMOSINICIO Y FIN EN 0
			int fin = 0;
			while (inicio < COLUMNAS && fin < COLUMNAS) {	//MIENTRAS NO NOS PASEMOS DEL NÚMERO DE COLUMNAS
				inicio = buscarInicio(M[i], fin);	//BUSCAMOS EL INICIO
				if (inicio < COLUMNAS) {		//SI ENCUENTRA UNINICIO VÁLIDO
					fin = buscarFin(M[i], inicio);	//BUSCAMOS FIN
					if (fin < COLUMNAS) {		//SI ENCUENTRA UN FIN VÁLIDO
						/**
						 * TENGO UNA SECUENCIA VÁLIDA
						 */						//HAGO TODO LO QUE TENGA QUE HACER CON LA SECUENCIA
						// imprimirSecuencia(M[i],inicio,fin);
						if (sonIguales(M[i], inicio, fin, P)) {		//SI LA SECUENCIA ES IGUAL A LA SECUENCIA PATRÓN
							elimminarSecuencia(M[i], inicio, fin);	//LA ELIMINO
						}
					}
				}
				fin++;		//PARA BUSCAR LA SIGUIENTE SECUENCIA TENGO QUE INCREMENTAR EL FIN
			}//FIN DEL WHILE, VUELOVE A BUSCAR LA SIGUIENTE SECUENCIA EN LA FILA
		}//FIN DEL FOR, PASA A LA SIGUIENTE FILA
		imprimirMatriz(M);
	}
	
	public static void imprimirMatriz(int[][] M){
	for (int fila = 0; fila < FILAS; fila++) {
		   System.out.print("| ");
		   for (int columna = 0; columna < COLUMNAS; columna++){
			   System.out.print( M[fila] [columna] + " | ");
		   }
		   System.out.println();
	   }
	}

	public static void elimminarSecuencia(int[] fila, int inicio, int fin) {
		//CORRIMIENTO IZQUIERDA
		for(int i=inicio;i<=fin;i++){
			corrimientoIzquierda(fila,inicio);
		}
	}

	public static void corrimientoIzquierda(int[] fila, int pos) {
		while(pos<COLUMNAS-1){
			fila[pos]=fila[pos+1];
			pos++;
		}
		
	}

	public static boolean sonIguales(int[] fila, int inicio, int fin, int[] p) {
		int tam = fin - inicio + 1;		//BUSCO EL TAMAÑO
		if (tam == MAX_PATRON) {		//SI SON DEL MISMO TAMAÑO
			boolean esIgual = true;		//INICIALIZO EL BOOLEAN EN TRUE
			int pos=inicio;				//POS SE VUELVE INICIO
			for (int i = 0; i < MAX_PATRON; i++) {		//RECORRO EL PATRON
				if (p[i] != fila[pos]) {//SI (VALOR) LA POS DEL PATRON ES DISTINTA A LA POSICION DE LA FILA
					esIgual = false;	//ESiGUAL SE VUELVE FALSE
				}
				pos++;		//INCREMENTO LA POS DE LA FILA EN UNO
			}
			return esIgual;		//RETORNOEL VALOR DE ESIGUAL
		}else{				//SI NO TIENEN EL MISMMO TAMAÑO
			return false;			//RETORNO FALSE
		}
	}

	public static void imprimirSecuencia(int[] fila, int inicio, int fin) {
		for (int i = inicio; i <= fin; i++) {
			System.out.print(fila[i] + ", ");
		}
		System.out.println();
	}

	public static int buscarFin(int[] fila, int pos) {
		while (pos < COLUMNAS && fila[pos] != 0) {
			pos++;
		}
		if (pos < COLUMNAS) {
			return pos - 1;
		} else {
			return pos;
		}
	}

	public static int buscarInicio(int[] fila, int pos) {
		while (pos < COLUMNAS && fila[pos] == 0) {
			pos++;
		}
		return pos;
	}
}
