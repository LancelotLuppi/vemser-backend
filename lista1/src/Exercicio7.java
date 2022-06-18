import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Valor para a variavel A:");
        int primeiraVariavel = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Valor para a variavel B:");
        int segundaVariavel = scanner.nextInt();
        scanner.nextLine();

        int aux = primeiraVariavel;
        primeiraVariavel = segundaVariavel;
        segundaVariavel = aux;

        System.out.println("Valor na variavel A: " + primeiraVariavel);
        System.out.println("Valor na variavel B: " + segundaVariavel);
    }
}
