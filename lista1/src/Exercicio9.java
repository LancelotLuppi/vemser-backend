import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe quantos anos voce tem:");
        int idadeAnos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Agora informe quantos meses se passaram desde seu ultimo aniversario:");
        int idadeMeses = scanner.nextInt();
        scanner.nextLine();

        System.out.println("E quantos dias passaram desde o início do mes atual (ou aniversario caso seja nesse mes):");
        int idadeDias = scanner.nextInt();
        scanner.nextLine();

        int diasTotais = (idadeAnos * 365) + (idadeMeses * 30) + idadeDias;
        System.out.println("Voce viveu " + diasTotais + " dias :D");
    }
}
