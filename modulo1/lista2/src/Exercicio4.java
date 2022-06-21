import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = new int[3];

        for(int i=0; i< numeros.length; i++){
            System.out.println("Informe um numero:");
            numeros[i] = scanner.nextInt();
            scanner.nextLine();
        }
        int aux;
        for(int i=0; i< numeros.length; i++){
            for(int j=i+1;j< numeros.length; j++){
                if(numeros[i] > numeros[j]){
                    aux = numeros[j];
                    numeros[j] = numeros[i];
                    numeros[i] = aux;
                }
            }
        }
        System.out.println("Menor valor: " + numeros[0]);
    }
}
