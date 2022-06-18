import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o seu nome: ");
        String nome = scanner.nextLine();

        System.out.println("Informe sua idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Informe sua cidade: ");
        String cidade = scanner.nextLine();

        System.out.println("Informe seu Estado: ");
        String estado = scanner.nextLine();

        System.out.println("Seu nome é " + nome + ", você tem " + idade + " anos, é da cidade de "
        + cidade + ", situada no estado de " + estado);
    }
}
