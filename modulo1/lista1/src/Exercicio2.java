import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int primeiraNota = scanner.nextInt();
        scanner.nextLine();
        int segundaNota = scanner.nextInt();
        scanner.nextLine();
        int terceiraNota = scanner.nextInt();
        scanner.nextLine();
        int quartaNota = scanner.nextInt();

        double media = (primeiraNota + segundaNota + terceiraNota + quartaNota) / 4;


        if(media <= 5){
            System.out.println("Reprovado");
        }
        if(media>5 && media<7){
            System.out.println("Em exame");
        }
        if(media>=7 && media<=10){
            System.out.println("Aprovado");
        }
        System.out.println("Media: " + media);
    }
}
