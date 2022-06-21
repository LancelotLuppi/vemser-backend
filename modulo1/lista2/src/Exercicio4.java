import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = new int[3];
        int menorValor = Integer.MAX_VALUE;
        int posicaoMenor = 0;

        for(int i=0; i< numeros.length; i++){
            System.out.println("Informe um numero:");
            numeros[i] = scanner.nextInt();
            scanner.nextLine();
        }
        int aux;
        for(int i=0; i< numeros.length; i++){
            if(numeros[i]<menorValor){
                menorValor = numeros[i];
                posicaoMenor = i;
            }
        }
        System.out.println("Posicao do menor: " + posicaoMenor);
    }
}
