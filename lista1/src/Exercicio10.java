import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Numero de eleitores:");
        double eleitores = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Numero de votos brancos:");
        double votosBrancos = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Numero de votos nulos:");
        double votosNulos = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Numero de votos validos:");
        double votosValidos = scanner.nextDouble();
        scanner.nextLine();

        double percentualNulos = (votosNulos/eleitores) * 100;
        double percentualBrancos = (votosBrancos/eleitores) * 100;
        double percentualValidos = (votosValidos/eleitores) * 100;

        System.out.println("Percentual de votos brancos: " + percentualBrancos + "%");
        System.out.println("Percentual de votos nulos: " + percentualNulos + "%");
        System.out.println("Percentual de votos validos: " + percentualValidos + "%");
    }
}
