import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Apresentando o jogo para o usuário
        System.out.println("\nVamos jogar Advinha, primeiro um jogador deve escolher um numero, \n" +
                "em seguida, o segundo jogador devera tentar advinhar o numero escolhido. \n" +
                "O sistema ira informar caso o numero digitado eh menor ou maior que o numero escolhido.\n" +
                "Boa sorte :)");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(" ");

        //Escolha do primeiro jogador
        System.out.println("O primeiro jogador deve escolher um numero: ");
        int numeroEscolhido = scanner.nextInt();
        scanner.nextLine();

        //Tempo para que leiam as regras
        System.out.println("\nAgora iremos dar uma limpada na tela para nao haver trapacas :x");
        System.out.println("Para continuar, pressione 1");
        int prosseguir = scanner.nextInt();
        scanner.nextLine();

        //Garantindo que irá prosseguir
        while(prosseguir !=1) {
            System.out.println("Por favor, digite 1");
            prosseguir = scanner.nextInt();
            scanner.nextLine();
        }

        //Limpando a tela
        if(prosseguir ==1) {
            for(int i=0; i<30; i++) {
                System.out.println(" ");
            }
        }

        //Sistema de chutes
        while(true) {
            System.out.println("Chute do segundo jogador:");
            int chute = scanner.nextInt();
            scanner.nextLine();
            if(chute == numeroEscolhido) {
                System.out.println("Parabens, voce acertou ^^");
                break;
            }
            if(chute>numeroEscolhido) {
                System.out.println("Dica: o numero escolhido eh menor\n");
            }
            if(chute<numeroEscolhido) {
                System.out.println("Dica: o numero escolhido eh maior\n");
            }
        }
    }

}
