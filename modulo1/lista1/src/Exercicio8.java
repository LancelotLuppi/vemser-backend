import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o valor da base do triangulo:");
        double base = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Informe o valor da altura do triangulo:");
        double altura = scanner.nextDouble();
        scanner.nextLine();

        double area = (base * altura) / 2;
        System.out.println("Valor da area: " + area);
    }
}
