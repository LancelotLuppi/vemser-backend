import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int LINHA = 5;
        final int COLUNA = 4;
        double matrizEscolar[][] = new double[LINHA][COLUNA];

        for(int i=0; i<LINHA; i++) {
            System.out.println("Informe a matricula do aluno:");
            matrizEscolar[i][0]= scanner.nextInt();
            scanner.nextLine();
            System.out.println("Informe a media das provas do aluno:");
            matrizEscolar[i][1]= scanner.nextInt();
            scanner.nextLine();
            System.out.println("Informe a media dos trabalhos do aluno:");
            matrizEscolar[i][2]= scanner.nextInt();
            scanner.nextLine();
            matrizEscolar[i][3] = (matrizEscolar[i][1] * 0.6 + matrizEscolar[i][2] * 0.4);
        }
        double maiorNotaFinal = 0;
        for(int i=0; i< matrizEscolar.length; i++) {
            for(int k=0; k<matrizEscolar[i].length; k++) {
                if(matrizEscolar[i][3] > maiorNotaFinal) {
                    maiorNotaFinal = matrizEscolar[i][3];
                }
            }
        }
        double numeroMatricula = 0;
        for(int i=0; i<matrizEscolar.length; i++) {
            for(int k=0; k<matrizEscolar[i].length; k++){
                if(maiorNotaFinal == matrizEscolar[i][3]) {
                    numeroMatricula = matrizEscolar[i][0];
                }
            }
        }

        System.out.println("Matricula da maior nota: " + numeroMatricula);
        System.out.println("Maior nota final: " + maiorNotaFinal);

    }
}
