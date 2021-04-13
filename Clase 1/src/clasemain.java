import java.util.Scanner;
public class clasemain {
    public static void main(String[] args) {
            Scanner epson= new Scanner(System.in);
            int n1, n2 , n3, n4 ;
            //punto numero 1
            System.out.println("Ingrese un Numero mi pana :v");
            n1 = epson.nextInt();
            System.out.println("Tu numero dividido por 2 = " + (n1/2));
            System.out.println("Tu numero dividido por 3 = " + (n1/3));
            System.out.println("Tu numero dividido por 4 = " + (n1/4));
            //punto numero 2
            System.out.println("ahora ingresa otro numero wei");
            n2= epson.nextInt();
            System.out.println("otro numero, vato:");
            n3= epson.nextInt();
            System.out.println("El primer numero la tiene, digo, es mas grande?: " + (n2>n3) );
            boolean resultado =  n2%2==0 && n3%2==0;
            System.out.println("Los numeros ingresados son pares?" + resultado);
            //punto numero 3
            System.out.println("Si, otro numero :v");
            n4=epson.nextInt();
            boolean mul6y7 = n4%6==0 && n4%7==0;
            System.out.println("tu numero es multiplo de 6 y 7? : " + mul6y7);
            boolean may30mul2omenoig30 = (n4>30 && n4%2==0) || (n4<=30);
            System.out.println("tu numero es mayor a 30 y multiplo de 2 o menor o igual a 30? " + may30mul2omenoig30);
    }
}
