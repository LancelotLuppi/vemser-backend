public class Exercicio7 {
    public static void main(String[] args) {

        final int LINHA = 4;
        final int COLUNA = 4;
        int contador = 0;
        int[][] matriz = {
                {32, 12, 54, 2},
                {2, 7, 45, 8},
                {9, 3, 21, 6},
                {5, 1, 76, 11}
        };

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
