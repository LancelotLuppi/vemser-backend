import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um dos seguintes estados: ");
        System.out.println("1 - Rio Grande do Sul");
        System.out.println("2 - São Paulo");
        System.out.println("3 - Santa Catarina");

        int escolhaEstado = scanner.nextInt();
        scanner.nextLine();
        switch (escolhaEstado){
            case 1 -> {
                System.out.println("Escolha uma cidade:");
                System.out.println("1 - Gramado");
                System.out.println("2 - Bento Gonçalves");
                System.out.println("3 - Caxias do Sul");
            }
            case 2 -> {
                System.out.println("Escolha uma cidade:");
                System.out.println("1 - São Paulo");
                System.out.println("2 - Campos do Jordão");
                System.out.println("3 - Guarujá");
            }
            case 3 -> {
                System.out.println("Escolha uma cidade:");
                System.out.println("1 - Florianópolis");
                System.out.println("2 - Blumenau");
                System.out.println("3 - Balneário Camboriú");
            }
            default -> {
                System.out.println("Escolha uma cidade válida!");
            }
        }

        if(escolhaEstado == 1){
            int escolhaCidade = scanner.nextInt();
            switch (escolhaCidade) {
                case 1 -> {
                    System.out.println("Você selecionou Gramado - RS.");
                    System.out.println("População: 36.864 (estimada 2021)");
                    System.out.println("PIB per capita: 62.317R$ (2019)");
                    System.out.println("Salário médio mensal: 2,5 salários mínimos (2019)");
                    System.out.println("Principal evento/festa: Natal luz");
                }
                case 2 -> {
                    System.out.println("Você selecionou Bento Gonçalves - RS.");
                    System.out.println("População: 123.090 (estimada 2021)");
                    System.out.println("PIB per capita: 52.716R$ (2019)");
                    System.out.println("Salário médio mensal: 3,1 salários mínimos (2019)");
                    System.out.println("Principal evento/festa: Vindima");
                }
                case 3 -> {
                    System.out.println("Você selecionou Caxias do Sul - RS.");
                    System.out.println("População: 523.716 (estimada 2021)");
                    System.out.println("PIB per capita: 52.873R$ (2019)");
                    System.out.println("Salário médio mensal: 2,9 salários mínimos (2019)");
                    System.out.println("Principal evento/festa: Festa da Uva");
                }
            }
        }
        if(escolhaEstado == 2){
            int escolhaCidade = scanner.nextInt();
            switch (escolhaCidade) {
                case 1 -> {
                    System.out.println("Você selecionou São Paulo - SP.");
                    System.out.println("População: 12.253.503 (estimada 2021)");
                    System.out.println("PIB per capita: 62.341R$ (2019)");
                    System.out.println("Salário médio mensal: 4,1 salários mínimos (2019)");
                    System.out.println("Principal evento/festa:  Lollapalooza");
                }
                case 2 -> {
                    System.out.println("Você selecionou Campos do Jordão - SP.");
                    System.out.println("População: 52.713 (estimada 2021)");
                    System.out.println("PIB per capita: 25.312R$ (2019)");
                    System.out.println("Salário médio mensal: 2,0 salários mínimos (2019)");
                    System.out.println("Principal evento/festa: Festival de Inverno Campos do Jordão");
                }
                case 3 -> {
                    System.out.println("Você selecionou Guarujá - SP.");
                    System.out.println("População: 324.977 (estimada 2021)");
                    System.out.println("PIB per capita: 28.417R$ (2019)");
                    System.out.println("Salário médio mensal: 3,0 salários mínimos (2019)");
                    System.out.println("Principal evento/festa: Guarufestival");
                }
            }
        }
        if(escolhaEstado == 3){
            int escolhaCidade = scanner.nextInt();
            switch (escolhaCidade) {
                case 1 -> {
                    System.out.println("Você selecionou Florianópolis - SC.");
                    System.out.println("População:516.524 (estimada 2021)");
                    System.out.println("PIB per capita: 43.842R$)");
                    System.out.println("Salário médio mensal: 4,5 salários mínimos (2019)");
                    System.out.println("Principal evento/festa:  Bigfest");
                }
                case 2 -> {
                    System.out.println("Você selecionou Blumenau - SC.");
                    System.out.println("População: 366.418 (estimada 2021)");
                    System.out.println("PIB per capita: 48.416R$ (2019)");
                    System.out.println("Salário médio mensal: 2,8 salários mínimos (2019)");
                    System.out.println("Principal evento/festa: Oktoberfest Blumenau");
                }
                case 3 -> {
                    System.out.println("Você selecionou Balneário Camboriú - SC.");
                    System.out.println("População: 149.227 (estimada 2021)");
                    System.out.println("PIB per capita: 42.524R$ (2019)");
                    System.out.println("Salário médio mensal: 2,5 salários mínimos (2019)");
                    System.out.println("Principal evento/festa: Festival Gastronomico de Balneario Camburiu");
                }
            }
        }

    }
}
