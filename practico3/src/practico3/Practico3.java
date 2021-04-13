
package practico3;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Practico3 {

    public static void main(String[] args) {
        int anio, mes;
        Scanner lector = new Scanner(System.in);
        System.out.println("ingrese un mes (1 al 12)");
        try{
        mes = lector.nextInt();
        if ((mes >= 1) && (mes <= 12)){
            switch(mes){
                case 3, 5, 7, 9, 10, 12 -> System.out.println("Tiene 31 dias");
                case 4, 6, 8, 11 -> System.out.println("Tiene 30 dias");
                case 2 -> {
                    System.out.println("Ingrese el año");
                    anio = lector.nextInt();
                    if ((anio % 4 == 0)&&(anio % 100 !=0) || (anio % 400 == 0) ){
                        System.out.println("El año es bisiesto, Febrero tiene 29 dias");
                    }else{
                        System.out.println("El año no es bisiesto, Febrero tiene 28 dias");
                    }                    
                }
            }
        }else{
            System.out.println("ingrese un mes valido");
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "INGRESE UN NUMERO!!!","hey!",JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
