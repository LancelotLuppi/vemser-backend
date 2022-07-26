import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Digite sua data de nascimento no padrao dd/mm/yyyy");
            LocalDate dataAniversario = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate dataAutal = LocalDate.now();

            if(dataAniversario.withYear(dataAutal.getYear()).isBefore(dataAutal)) {
                Period tempoAteAniversarioProxAno = Period.between(dataAutal, dataAniversario.withYear(dataAutal.getYear() + 1));
                System.out.println("Tempo ate o seu proximo aniversario: \n" +
                        tempoAteAniversarioProxAno.getDays() + " dias e " + tempoAteAniversarioProxAno.getMonths() + " meses!");
            } else {
                Period tempoAteAniversario = Period.between(dataAutal, dataAniversario.withYear(dataAutal.getYear()));
                System.out.println("Tempo ate o seu proximo aniversario: \n" +
                        tempoAteAniversario.getDays() + " dias e " + tempoAteAniversario.getMonths() + " meses!");
            }

        } catch (DateTimeException ex) {
            System.err.println("O formato da data deve ser DD/MM/YYYY!");
        }

    }
}
