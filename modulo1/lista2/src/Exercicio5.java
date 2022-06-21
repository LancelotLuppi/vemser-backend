import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] vetor = new int[20];

        for(int i=0; i<20; i++){
            System.out.println("Informe um número inteiro:");
            vetor[i] = scanner.nextInt();
            scanner.nextLine();
        }
        for(int i=19; i>=0; i--){
            System.out.println(vetor[i]);
        }
    }
}
