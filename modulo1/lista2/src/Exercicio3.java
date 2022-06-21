import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<Double> alturas = new ArrayList<>();
        ArrayList<Integer> idades = new ArrayList<>();
        ArrayList<Double> pesos = new ArrayList<>();

        do {
            System.out.println("Informe o nome de um jogador:");
            String nome = scanner.nextLine().toLowerCase();
            if(nome.equals("sair")) {
                break;
            }
            nomes.add(nome);

            System.out.println("\nInforme a altura desse jogador:");
            Double altura = scanner.nextDouble();
            scanner.nextLine();
            alturas.add(altura);

            System.out.println("\nInforme a idade desse jogador:");
            Integer idade = scanner.nextInt();
            scanner.nextLine();
            idades.add(idade);

            System.out.println("\nInforme o peso desse jogador:");
            Double peso = scanner.nextDouble();
            scanner.nextLine();
            pesos.add(peso);
        } while(true);

        Double maiorAltura = Collections.max(alturas);
        int indexMaiorAltura = alturas.indexOf(maiorAltura);
        String jogadorMaisAlto = nomes.get(indexMaiorAltura);

        Double maiorPeso = Collections.max(pesos);
        int indexMaiorPeso = pesos.indexOf(maiorPeso);
        String jogadorMaisPesado = nomes.get(indexMaiorPeso);

        double somador = 0;
        for(int i=0; i<alturas.size(); i++) {
            somador += alturas.get(i);
        }
        double mediaAlturas = somador/alturas.size();

        System.out.println("Jogadores registrados: " + nomes.size());
        System.out.println("Jogador mais alto e altura: " + jogadorMaisAlto + " || " + maiorAltura);
        System.out.println("Jogador mais pesado e peso: " + jogadorMaisPesado + " || " + maiorPeso);
        System.out.println("Media de alturas: " + mediaAlturas);


    }
}
