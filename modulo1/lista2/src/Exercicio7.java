import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int LINHA = 4;
        final int COLUNA = 4;
        int contador = 0;

        //Leitura da matriz
        int[][] matriz = new int[LINHA][COLUNA];
        for(int i=0; i<LINHA; i++){
            for(int k=0; k<COLUNA; k++){
                matriz[i][k] = scanner.nextInt();
                scanner.nextLine();
            }
        }

        //Contador de valores +10;
        for(int i=0; i<LINHA; i++){
            for(int k=0; k<COLUNA; k++){
                if(matriz[i][k] > 10){
                    contador++;
                }
            }
        }
        System.out.println("Encontrei " + contador + " valores maiores que 10");
    }
}
