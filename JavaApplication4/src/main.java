
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        Scanner epson = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        int num5 =0;
        int num0 =0;
        int elegido=0;
        int ganador = 0;
        for (int i=0; i<10000; i++){
           int random = (int)(Math.random()*4);
           switch (random + 1){
               case 1:
                   num1 = num1+1;
               break;
               case 2:
                   num2 = num2+1;
               break;
               case 3:
                   num3 = num3+1;
               break;
               case 4:
                   num4 = num4+1;
               break;
               case 5:
                   num5 = num5+1;
               break;
               case 0:
                   num0 = num0+1;
               break;
           }
        }
        if ((num1 > num2) && (num1 > num3) && (num1> num4)){
            ganador = 1;
        }else if ((num2 > num3) && (num2> num4)){
            ganador = 2;
        }else if (num3> num4){
            ganador = 3;
        }else{
            ganador = 4;
        }
        System.out.println("DADOS TIRADOS! que dado salio mas?");
        elegido = epson.nextInt();
        if (elegido == ganador){
            System.out.println("GANASTE VAMO LO PIBE");
        } else {
            System.out.println("PERDISTE PAJA >:v");
        }
        System.out.println("FACILITO");
    }
}