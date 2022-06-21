import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vetor[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        boolean achou = false;

        System.out.println("Digite um numero que deseja procurar:");
        int busca = scanner.nextInt();


        for(int i=0; i< vetor.length; i++){
            if(busca == vetor[i]){
                System.out.println("Achei o numero esperado");
                achou = true;
            }
        }
        if(achou == false) {
            System.out.println("Desculpe, mas nao existe esse numero digitado");
        }
    }
}
