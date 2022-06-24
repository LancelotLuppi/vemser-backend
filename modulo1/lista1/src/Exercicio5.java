import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o valor da hora:");
        double valorHora = scanner.nextDouble();;
        scanner.nextLine();

        System.out.println("Informe a quantidade de horas normais trabalhadas:");
        double horasNormaisTrabalhadas = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Informe a quantidade de hora extra 50% trabalhada:");
        double horasExtra50 = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Informe a quantidade de hora extra 100% trabalhada:");
        double horasExtras100 = scanner.nextDouble();
        scanner.nextLine();

        double salarioBruto = (horasNormaisTrabalhadas * valorHora) + (horasExtra50 * valorHora * 1.5) + (horasExtras100 * valorHora * 2);
        System.out.println("Salario bruto: " + salarioBruto);

    }
}
