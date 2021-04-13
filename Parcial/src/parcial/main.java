
package parcial;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
       Scanner lector = new Scanner(System.in);
       int numero = 0;
       int pares = 0;
       int impares = 0;
       int cont10 = 0;
       int cont17 = 0;
       try{
            while (numero != -1){ //usar constante
           System.out.println("Ingrese un número, ponga '-1' para dejar de ingresar ");
           numero = lector.nextInt(); // usar funcion para obtenernumero valido
           if (numero == -1){
               System.out.println("Saliendo del programa");
           }else if (numero >= 20){ //Usar una constante. Estotiene q ser un while
               System.out.println("Ingrese un numero menor a 20");
           }else{
               if (verificarpar(numero)==true){//no hace falta  == ya da true
                   pares = pares + 1;
               }else{
                   impares = impares + 1;
               }
               if (verificarmultiplo(numero)== true){
                   pedirletras();
               }
               if (numero == 10){//usar constante
                   cont10=cont10+1;
               }
               if (numero == 17){
                   cont17=cont17+1;
               }
           }
       }
       }catch (Exception e){
           
       }
      
        System.out.println("la cantidad de numeros pares fue: " + pares );
        System.out.println("la cantidad de numeros impares fue: " + impares );
        System.out.println("el porcentaje de pares fue: " + sacarporcentaje(pares, impares) + "%" );
        contadores(cont10,cont17);
    }
    static boolean verificarpar(int num){
        if (num%2 == 0){
            return true;
        }else{
            return false;
        }
    }
    static int sacarporcentaje(int pares, int impares){
        int total = pares + impares;
        int porcentaje = (pares * 100)/total;
        return porcentaje;
    }
    static boolean verificarmultiplo(int num){ //es igual a verificar par, mandar por parametro el %
        if (num % 3 == 0){ // return num % multiplo == 0
            return true;
        }else{
            return false;
        }
    }
    static void pedirletras (){
        Scanner lectorletras = new Scanner(System.in);
        String letra1; //usar char, son caracteres
        String letra2;
        do {
            System.out.println("Ingrese primer vocal minuscula");
            letra1 = lectorletras.nextLine();
        }while (letra1 != "a"  || letra1 != "e"|| letra1 != "i"|| letra1 != "o"|| letra1 != "u"); //hacerlo en metodo "esvocal", usar &&, usar char
        do {
            System.out.println("Ingrese segunda vocal minuscula");
            letra2 = lectorletras.nextLine();
        }while (letra2 != "a"  || letra2!="e"|| letra2!="i"|| letra2!="o"|| letra2!="u");
        if (vocales(letra1)>vocales(letra2)){
            System.out.println("la vocal 2 esta mas cerca de la A");
        }else{
            System.out.println("la vocal 1 esta mas cerca de la A");
        }
        
    }
    static int vocales(String letra){ //usar char para comparar con "<"
        int posicion = 0;
        switch (letra){
            case "a":
                posicion = 1;
                break;
            case "e":
                posicion = 2;
                break;
            case "i":
                posicion = 3;
                break;
            case "o":
                posicion = 4;
                break;
            case "u":
                posicion = 5;
                break;
            default:
                posicion = 6;
                break;
        }
        return posicion;
    }
    static void contadores(int contador10, int contador17){
        if (contador10>contador17){
            System.out.println("Hubo mas 10 que 17");
        }else if(contador10 == contador17){
            System.out.println("Hubo igual cantidades de 10 que 17");
        }else{
            System.out.println("Hubo mas 17 que 10");
        }
    }

}
