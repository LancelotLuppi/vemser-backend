import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Informe as datas no padrao DD/MM/YYYY! \n");

            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.println("Primeira data:");
            LocalDate primeiraData = LocalDate.parse(scanner.nextLine(), format);

            System.out.println("Segunda data:");
            LocalDate segundaData = LocalDate.parse(scanner.nextLine(), format);

            if(primeiraData.isAfter(segundaData)) {
                Period diferencaDatas = Period.between(segundaData, primeiraData);
                mostrarMensagemDeDiferencas(diferencaDatas);
            } else {
                Period diferencaDatas = Period.between(primeiraData, segundaData);
                mostrarMensagemDeDiferencas(diferencaDatas);
            }

        } catch (DateTimeException ex) {
            System.err.println("O formato da data deve ser DD/MM/YYYY!");
        }
    }

    public static void mostrarMensagemDeDiferencas(Period diferenca) {
        System.out.println("Difenreca: "
                + diferenca.getDays() + " dias, "
                + diferenca.getMonths() + " meses e "
                + diferenca.getYears() +" anos.");
    }
}
